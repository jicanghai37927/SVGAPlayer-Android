package com.example.ponycui_home.svgaplayer;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;

import org.jetbrains.annotations.NotNull;

import java.net.URL;
import java.util.ArrayList;

public class AnimationFromAssetsActivity extends Activity {

    SVGAImageView animationView = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        animationView = new SVGAImageView(this);
        animationView.setBackgroundColor(Color.BLACK);
        animationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadAnimation();
            }
        });
        loadAnimation();
        setContentView(animationView);
    }

    private void loadAnimation() {
        SVGAParser parser = new SVGAParser(this);
        parser.decodeFromAssets("matte1.svga", new SVGAParser.ParseCompletion() {
            @Override
            public void onComplete(@NotNull SVGAVideoEntity videoItem) {
                animationView.setVideoItem(videoItem);
                animationView.startAnimation();
            }
            @Override
            public void onError() {

            }
        });
    }

    private ArrayList<String> samples = new ArrayList();

    private String randomSample() {
        if (samples.size() == 0) {
            samples.add("angel.svga");
            samples.add("alarm.svga");
            samples.add("EmptyState.svga");
            samples.add("heartbeat.svga");
            samples.add("posche.svga");
            samples.add("rose_1.5.0.svga");
            samples.add("rose_2.0.0.svga");
            samples.add("test.svga");
            samples.add("test2.svga");
        }
        return samples.get((int) Math.floor(Math.random() * samples.size()));
    }

}
