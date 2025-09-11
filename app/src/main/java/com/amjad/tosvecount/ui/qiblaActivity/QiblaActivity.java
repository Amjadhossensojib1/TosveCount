package com.amjad.tosvecount.ui.qiblaActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Bundle;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.amjad.tosvecount.R;

public class QiblaActivity extends AppCompatActivity implements SensorEventListener {

    private ImageView compassImg;
    private TextView qiblaText;
    private SensorManager sensorManager;
    private float[] gravity = new float[3];
    private float[] geomagnetic = new float[3];
    private float currentDegree = 0f;
    private float qiblaDirection = 0f;

    private static final float ALPHA = 0.25f;

    private final float QIBLA_LAT = 21.4225f;
    private final float QIBLA_LON = 39.8262f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qibla);

        compassImg = findViewById(R.id.compass_img);
        qiblaText = findViewById(R.id.qibla_direction);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        // Dhaka location
        Location myLocation = new Location("dummy");
        myLocation.setLatitude(23.8103);
        myLocation.setLongitude(90.4125);
        qiblaDirection = calculateQiblaDirection(myLocation);
    }

    private float calculateQiblaDirection(Location location) {
        double userLat = Math.toRadians(location.getLatitude());
        double userLon = Math.toRadians(location.getLongitude());
        double kaabaLat = Math.toRadians(QIBLA_LAT);
        double kaabaLon = Math.toRadians(QIBLA_LON);

        double dLon = kaabaLon - userLon;

        double x = Math.sin(dLon) * Math.cos(kaabaLat);
        double y = Math.cos(userLat) * Math.sin(kaabaLat) -
                Math.sin(userLat) * Math.cos(kaabaLat) * Math.cos(dLon);

        double bearing = Math.toDegrees(Math.atan2(x, y));
        return (float) ((bearing + 360) % 360);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_UI);
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
                SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
            gravity = lowPassFilter(event.values.clone(), gravity);
        else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD)
            geomagnetic = lowPassFilter(event.values.clone(), geomagnetic);

        if (gravity != null && geomagnetic != null) {
            float[] R = new float[9];
            float[] I = new float[9];
            boolean success = SensorManager.getRotationMatrix(R, I, gravity, geomagnetic);
            if (success) {
                float[] orientation = new float[3];
                SensorManager.getOrientation(R, orientation);
                float azimuth = (float) Math.toDegrees(orientation[0]);
                azimuth = (azimuth + 360) % 360;

                float direction = azimuth - qiblaDirection;
                direction = (direction + 360) % 360;

                RotateAnimation ra = new RotateAnimation(currentDegree, -direction,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                ra.setDuration(250); // কম সময় যাতে কম কাঁপে
                ra.setFillAfter(true);

                compassImg.startAnimation(ra);
                currentDegree = -direction;

                qiblaText.setText("Facing: " + Math.round(azimuth) + "° | Qibla: " + Math.round(qiblaDirection) + "°");
            }
        }
    }

    private float[] lowPassFilter(float[] input, float[] output) {
        if (output == null) return input;

        for (int i = 0; i < input.length; i++) {
            output[i] = output[i] + ALPHA * (input[i] - output[i]);
        }
        return output;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // not used
    }
}
