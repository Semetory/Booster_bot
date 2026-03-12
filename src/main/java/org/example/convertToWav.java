package org.example;

import com.pengrad.telegrambot.model.File;
import ws.schild.jave.Encoder;
import ws.schild.jave.MultimediaObject;
import ws.schild.jave.encode.AudioAttributes;
import ws.schild.jave.encode.EncodingAttributes;

public File convertToWav(File oggFile) {
    File target = new File("voice.wav");
    AudioAttributes audio = new AudioAttributes();
    audio.setCodec("pcm_s16le");
    audio.setChannels(1);
    audio.setSamplingRate(44100);

    EncodingAttributes attrs = new EncodingAttributes();
    attrs.setInputFormat("wav");
    attrs.setAudioAttributes(audio);

    Encoder encoder = new Encoder();
    encoder.encode(new MultimediaObject(oggFile), target, attrs);
    return target;
}

