package cn.ddssst.wuliao.util;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.client.utils.URLEncodedUtils;

import net.sf.json.JSONObject;
public class HttpRequest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String url="http://yingyan.baidu.com/api/v3/entity/add?ak=YZGHqCsmjc65wYUFi0dxahI9GVUB92kG&service_id=150460&entity_name=demo&entity_desc=entity_desc";
		JSONObject jsonObject=httpRequst(url, "post", null);
		String status=jsonObject.getString("status");
		String message=jsonObject.getString("message");
		System.out.println(status);
		System.out.println(message);
	}
	
	
	
	
	
	public static JSONObject httpRequst(String requestUrl,String requetMethod,String outputStr){
		JSONObject jsonobject=null;
		StringBuffer buffer=new StringBuffer();
		try
		{
			//创建SSLContext对象，并使用我们指定的新人管理器初始化
			TrustManager[] tm={new MyX509TrustManager()};
			SSLContext sslcontext=SSLContext.getInstance("SSL","SunJSSE");
			sslcontext.init(null, tm, new java.security.SecureRandom());
			//从上述SSLContext对象中得到SSLSocktFactory对象
			SSLSocketFactory ssf=sslcontext.getSocketFactory();
			
			URL url=new URL(requestUrl);
			HttpsURLConnection httpUrlConn=(HttpsURLConnection)url.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);
			
			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			//设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requetMethod);
			
			if("GET".equalsIgnoreCase(requetMethod))
				httpUrlConn.connect();
			
			//当有数据需要提交时
			if(null!=outputStr)
			{
			OutputStream outputStream=httpUrlConn.getOutputStream();
			//注意编码格式，防止中文乱码
			outputStream.write(outputStr.getBytes("UTF-8"));
			outputStream.close();
			}
			
			//将返回的输入流转换成字符串
			InputStream inputStream=httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"utf-8");
			BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
			
			
			String str=null;
			while((str = bufferedReader.readLine()) !=null)
			{ 
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			//释放资源
			inputStream.close();
			inputStream=null;
			httpUrlConn.disconnect();
			jsonobject=JSONObject.fromObject(buffer.toString());
		}
		catch (ConnectException ce) {
			ce.printStackTrace();
			System.out.println(ce.getMessage());
		}
		catch (Exception e) {  
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return jsonobject;
	}

}
class MyX509TrustManager implements X509TrustManager
{

	public void checkClientTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
		// TODO Auto-generated method stub
		
	}

	public void checkServerTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
		// TODO Auto-generated method stub
		
	}

	public X509Certificate[] getAcceptedIssuers() {
		// TODO Auto-generated method stub
		return null;
	}
}
