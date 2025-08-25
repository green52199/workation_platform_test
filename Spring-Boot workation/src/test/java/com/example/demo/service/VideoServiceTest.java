package com.example.demo.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VideoServiceTest {

    private  final VideoService videoService = new VideoService();

    @Test
    void uploadVideo_returnsTheVideo() {
        String title = "Test Video";
        Video video = videoService.uploadVideo(title);
        assertEquals(title, video.getTitle());
        assertNotNull(video.getId());
    }

    @Test
    void playVideo_incrementsPlayCount() {
        String title = "Test Play Video";
        Video video = videoService.uploadVideo(title);
        videoService.playVideo(video.getId());
        assertEquals(1, video.getPlayCount());
    }

    @Test
    void getTopNViewedVideos_returnsSortedList() {
        Video v1 = videoService.uploadVideo("A");
        Video v2 = videoService.uploadVideo("B");
        videoService.playVideo(v2.getId());
        videoService.playVideo(v2.getId());
        videoService.playVideo(v1.getId());
        var topVideos = videoService.getTopNViewedVideos(2);
        assertEquals(v2, topVideos.get(0));
    }
}
