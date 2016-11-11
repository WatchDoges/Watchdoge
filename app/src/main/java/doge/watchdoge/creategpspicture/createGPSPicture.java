package doge.watchdoge.creategpspicture;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.Pair;

import doge.watchdoge.gpsgetter.DummyGpsCoordinates;
import doge.watchdoge.gpsgetter.GpsCoordinates;

import java.util.concurrent.ExecutionException;

/**
 * Created by Frey on 13.10.2016.
 */

public class createGPSPicture {

    public static Bitmap CreateGPSPictue(Pair<Double, Double> coordinates){
        //Pair<Double, Double> dummy = Pair.create(60.457027 ,2022.283202);
        //Pair<Double, Double> coordinates = input.getGPS();
        String imageUrl;
        if(coordinates==null || coordinates.first == null || coordinates.second == null){
            System.out.println("Using Android.location coordinates (googleAPI not supported or disabled!)");
            Pair<Double, Double> androidLocation =  GpsCoordinates.getGPS();
            if (androidLocation != null) {
                imageUrl = "http://maps.googleapis.com/maps/api/staticmap?&size=600x600&markers=color:blue|" +
                        androidLocation.first + ",%20" + androidLocation.second;
            }
            else{
                System.out.println("Using default dummy coordinates (googleAPI and android.Location not supported or disabled!)");
                Pair<Double, Double> dummy = DummyGpsCoordinates.getGPS();
                imageUrl = "http://maps.googleapis.com/maps/api/staticmap?&size=600x600&markers=color:blue|" +
                        dummy.first + ",%20" + dummy.second;

            }

        } else {
            imageUrl = "http://maps.googleapis.com/maps/api/staticmap?&size=600x600&markers=color:blue|" +
                    coordinates.first + ",%20" +coordinates.second;
        }

        Bitmap picture = null;
        try {
            picture = new GPSPicture().execute(imageUrl).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return picture;

    }
}
