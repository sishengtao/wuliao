package cn.ddssst.wuliao.util;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.sf.json.JSONObject;

public class WXUtils {

    /**
     * 微信公众号推送消息accessToken
     * @param appId
     * @param appSecret
     * @return
     */
    public static String accessToken(String appId, String appSecret){
        String accessToken = null;
        try {
            Map<String, String> data = new HashMap<String, String>();
            data.put("appid", appId);
            data.put("secret", appSecret);
            data.put("grant_type", "client_credential");
//		        String queryString = WxpubOAuth.httpBuildQuery(data);
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> e : data.entrySet()) {
                if (sb.length() > 0) {
                    sb.append('&');
                }
                sb.append(URLEncoder.encode(e.getKey(), "UTF-8")).append('=').append(URLEncoder.encode(e.getValue(), "UTF-8"));
            }
            String queryString = sb.toString();
            String accessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?" + queryString;
//		        String resp = httpGet(accessTokenUrl);
            String result = "";
            try {
                URL url = new URL(accessTokenUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                while ((line = rd.readLine()) != null) {
                    result += line;
                }
                rd.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

            JsonParser jp = new JsonParser();
            JsonObject respJson = jp.parse(result).getAsJsonObject();
            System.out.println("respJson==========================:"+respJson);
            if (respJson.has("errcode")) {
                return respJson.toString();
            }
            data.clear();
            accessToken=respJson.get("access_token").getAsString();
            System.out.println("微信公众号推送消息accessToken:"+accessToken);
        } catch (Exception e) {

        }
        return accessToken;
    }
    /**
     * 微信推送消息
     * @param token
     * @param template
     * @return
     */
    public static boolean sendTemplateMsg(String token, Template template) {
        String requestUrl="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
        requestUrl=requestUrl.replace("ACCESS_TOKEN", token);
        JSONObject jsonResult=HttpRequest.httpRequst(requestUrl, "POST", template.toJSON());
        if(jsonResult!=null){
            int errorCode=jsonResult.getInt("errcode");
            String errorMessage=jsonResult.getString("errmsg");
            if(errorCode==0){
                System.out.println("模板消息发送成功:"+jsonResult);
                return true;
            }else{
                System.out.println("模板消息发送失败:"+errorCode+","+errorMessage);
                return false;
            }
        }
        return false;
    }


}
