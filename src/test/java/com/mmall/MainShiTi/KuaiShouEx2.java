package com.mmall.MainShiTi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KuaiShouEx2 {
    public static void main(String[] args) {
        List<String> picAndVideoList = new ArrayList<>();
        picAndVideoList.add("v_0");
        picAndVideoList.add("v_1");
        picAndVideoList.add("v_2");
        picAndVideoList.add("p_3");
        picAndVideoList.add("p_4");
        picAndVideoList.add("p_5");
        picAndVideoList.add("p_6");
        picAndVideoList.add("p_7");
        picAndVideoList.add("v_8");
        picAndVideoList.add("v_9");
        List<String> result = new KuaiShouEx2().getRecommendResult(picAndVideoList,2);
        for(String resultStr:result){
            System.out.println(resultStr);
        }
    }

    private List<String> getRecommendResult(List<String> picAndVideoList, int maxInterval) {
        List<String> result = new ArrayList<>();
        if(picAndVideoList == null || picAndVideoList.size() ==0){
            return result;
        }
        Queue<String> videoQueue = new LinkedList<>();
        Queue<String> picQueue = new LinkedList<>();
        boolean firstPic = false;

        int index = 0;
        int picAndVedioSize = picAndVideoList.size();
        while (!firstPic && index < maxInterval){
            if(isVedio(picAndVideoList.get(index))){
                result.add(index,picAndVideoList.get(index));
                index ++;
            }else{
                firstPic = true;
            }
        }
        while (index < picAndVedioSize){
            if(isVedio(picAndVideoList.get(index))){
                videoQueue.add(picAndVideoList.get(index));
            }else{
                picQueue.add(picAndVideoList.get(index));
            }
            index ++;
        }
        int currentSize = result.size();
        while (!videoQueue.isEmpty() && !picQueue.isEmpty()){
            if(currentSize >= maxInterval){
                result.add(picQueue.poll());
                currentSize = 0;
            }else{
                result.add(videoQueue.poll());
                currentSize ++;
            }
        }
        while (!videoQueue.isEmpty()){
            result.add(videoQueue.poll());
        }
        if(currentSize >= maxInterval && !picQueue.isEmpty()){
            result.add(picQueue.poll());
        }
        return result;
    }

    public static boolean isVedio(String clip){
        if(clip.indexOf("v") > -1){
            return true;
        }
        return false;
    }
}
