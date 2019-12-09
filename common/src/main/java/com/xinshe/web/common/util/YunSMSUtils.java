//package com.xinshe.web.common.util;
//
//
//import com.alibaba.fastjson.JSONObject;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.stereotype.Component;
//
//import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;
//import java.util.HashMap;
//import java.util.Map;
//
//
//
//@Component
//public class YunSMSUtils {
//
//    private SendConfig sendConfig;
//
//    public YunSMSUtils(SendConfig sendConfig) {
//        this.sendConfig = sendConfig;
//    }
//
//    private String ENCODING = "UTF-8";
//
////    【懂房帝】举报短信提醒模版：系统收到用户（#userphone#）的房源举报，信息：#content#，具体链接为： #url# ，经纪人电话#agentphone#，请尽快处理。
//
//    public  String sendMessges(String info,String content) throws UnsupportedEncodingException {
//        JSONObject jsonObject = JSONObject.parseObject(info);
//        JSONObject contentInfo = JSONObject.parseObject(content);
//        String houseId = "";
//        String cityName = "";
//        String projName = "";
//        String price = "";
//        String buildArea = "";
//        if (StringUtils.isNotEmpty(contentInfo.getString("houseId"))){
//            houseId= contentInfo.getString("houseId");
//        }
//        if (StringUtils.isNotEmpty(contentInfo.getString("cityName"))) {
//            cityName = "," + contentInfo.getString("cityName");
//        }
//        if (StringUtils.isNotEmpty(contentInfo.getString("projName"))) {
//            projName = "," + contentInfo.getString("projName");
//        }
//        if (StringUtils.isNotEmpty(contentInfo.getString("price"))) {
//            price = "," + contentInfo.getString("price") + "万元";
//        }
//        if (StringUtils.isNotEmpty(contentInfo.getString("buildArea"))) {
//            buildArea = "," + contentInfo.getString("buildArea") + "平米";
//        }
//
//        //发送短信
//        Map<String, String> params = new HashMap<>();
//        params.put("apikey", sendConfig.getApiKey());
//        params.put("mobile", "18519288810,17610235000,13693525023");
//        params.put("tpl_id", sendConfig.getSendTemplate());
//        params.put("tpl_value", URLEncoder.encode("#userphone#", ENCODING) + "=" + URLEncoder.encode(jsonObject.getString("userPhone"), ENCODING)+ "&" +
//                                URLEncoder.encode("#content#", ENCODING) + "=" + URLEncoder.encode(houseId+cityName+projName+price+buildArea, ENCODING)+ "&" +
//                                URLEncoder.encode("#url#", ENCODING) + "=" + URLEncoder.encode(jsonObject.getString("url"), ENCODING)+ "&" +
//                                URLEncoder.encode("#agentphone#", ENCODING) + "=" + URLEncoder.encode(jsonObject.getString("agentPhone"), ENCODING));
//
//        return post("https://sms.yunpian.com/v2/sms/tpl_batch_send.json", params);
//    }
//
//    /**
//     * 发送登录验证码
//     * @param phone
//     * @param content
//     * @return
//     * @throws UnsupportedEncodingException
//     */
//    public String sendLoginVerifyCode(String phone,String content) throws UnsupportedEncodingException {
//        //发送短信
//        Map<String, String> params = new HashMap<>();
//        params.put("apikey", sendConfig.getApiKey());
//        params.put("mobile", phone);
//        params.put("tpl_id", "2513522");
//        params.put("tpl_value", URLEncoder.encode("#code#", ENCODING) + "=" +content);
//
//        return post("https://sms.yunpian.com/v2/sms/tpl_batch_send.json", params);
//    }
//
//    /**
//     * 摇号前给用户发送提示短信
//     * @param phone
//     * @param messageMap
//     * @return
//     * @throws UnsupportedEncodingException
//     */
//    public String sendMsgBeforeRock(String phone, Map<String, String> messageMap) throws UnsupportedEncodingException {
//        //发送短信
//        Map<String, String> params = new HashMap<>();
//        params.put("apikey", sendConfig.getApiKey());
//        params.put("mobile", phone);
//        params.put("tpl_id", "2859566");
//        params.put("tpl_value", URLEncoder.encode("#activityName#", ENCODING) + "=" + URLEncoder.encode(messageMap.get("activityName"), ENCODING) + "&" +
//                                URLEncoder.encode("#activityTime#", ENCODING) + "=" + URLEncoder.encode(messageMap.get("activityTime"), ENCODING) + "&" +
//                                URLEncoder.encode("#url#", ENCODING) + "=" + URLEncoder.encode(messageMap.get("url"), ENCODING) );
//        return post("https://sms.yunpian.com/v2/sms/tpl_batch_send.json", params);
//    }
//
//    /**
//     * 给摇号成功用户发送短信
//     * @param phone
//     * @param messageMap
//     * @return
//     * @throws UnsupportedEncodingException
//     */
//    public String sendMsgAfterRock(String phone, Map<String, String> messageMap) throws UnsupportedEncodingException {
//        //发送短信
//        Map<String, String> params = new HashMap<>();
//        params.put("apikey", sendConfig.getApiKey());
//        params.put("mobile", phone);
//        params.put("tpl_id", "2859568");
//        params.put("tpl_value", URLEncoder.encode("#activityName#", ENCODING) + "=" + URLEncoder.encode(messageMap.get("activityName"), ENCODING) + "&" +
//                                URLEncoder.encode("#totalUser#", ENCODING) + "=" + URLEncoder.encode(messageMap.get("totalUser"), ENCODING) + "&" +
//                                URLEncoder.encode("#individualGroup#", ENCODING) + "=" + URLEncoder.encode(messageMap.get("individualGroup"), ENCODING));
//        return post("https://sms.yunpian.com/v2/sms/tpl_batch_send.json", params);
//    }
//
//    public String activityPickSms(String phone, String activityName, String houseStr) throws UnsupportedEncodingException {
//        //发送短信
//        Map<String, String> params = new HashMap<>();
//        params.put("apikey", sendConfig.getApiKey());
//        params.put("mobile", phone);
//        params.put("tpl_id", "2859580");
//        params.put("tpl_value", URLEncoder.encode("#activityName#", ENCODING) + "=" +URLEncoder.encode(String.valueOf(activityName), ENCODING) + "&" +
//                                URLEncoder.encode("#houseStr#", ENCODING) + "=" +URLEncoder.encode(String.valueOf(houseStr), ENCODING));
//
//        return post("https://sms.yunpian.com/v2/sms/tpl_batch_send.json", params);
//    }
//
//    public String activityNoticeSms(String phone, Map<String, String> messageMap) throws UnsupportedEncodingException {
//        //发送短信
//        Map<String, String> params = new HashMap<>();
//        params.put("apikey", sendConfig.getApiKey());
//        params.put("mobile", phone);
//        params.put("tpl_id", "2859572");
//        params.put("tpl_value", URLEncoder.encode("#activityName#", ENCODING) + "=" +URLEncoder.encode(messageMap.get("activityName"),ENCODING) + "&" +
//                                URLEncoder.encode("#activityTime#", ENCODING) + "=" + URLEncoder.encode(messageMap.get("activityTime"), ENCODING) + "&" +
//                                URLEncoder.encode("#onOrOff#", ENCODING) + "=" + URLEncoder.encode(messageMap.get("onOrOff"), ENCODING) + "&" +
//                                URLEncoder.encode("#sortStr#", ENCODING) + "=" + URLEncoder.encode(messageMap.get("sortStr"), ENCODING) + "&" +
//                                URLEncoder.encode("#url#", ENCODING) + "=" + URLEncoder.encode(messageMap.get("url"), ENCODING));
//
//        return post("https://sms.yunpian.com/v2/sms/tpl_batch_send.json", params);
//    }
//}