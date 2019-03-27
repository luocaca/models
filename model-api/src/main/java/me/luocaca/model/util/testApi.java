package me.luocaca.model.util;

import jdk.nashorn.internal.parser.JSONParser;
import okhttp3.*;
import okio.BufferedSink;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;

public class testApi {


    static List<Cookie> localCookies = new ArrayList<>();

    public static String forkReose(String keyWord, int page) {

        String result = "";
        int portNum = 1080;
//        String add = "www.luocaca.cn";
        String add = "127.0.0.1";



//        String up = base64("admin:admin")

        Authenticator authenticator = (route, response) -> response.request().newBuilder()
//                .addHeader("Proxy-Authorization", "root:root")
                .addHeader("Proxy-Authorization", "Basic cm9vdDpyb290")
//                .addHeader("authorization", "Basic cm9vdDpyb290")
                .build();


        OkHttpClient client = new OkHttpClient.Builder().cookieJar(new CookieJar() {
            @Override
            public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
                for (Cookie cookie : list) {
                    System.out.println("" + cookie.name());
                }

                localCookies = list;
            }

            @Override
            public List<Cookie> loadForRequest(HttpUrl httpUrl) {
//                List<Cookie> cookies = new ArrayList<>();
//                cookies.add(new Cookie());
                System.out.println("dot");
                return localCookies;
            }
        })
//                .proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(add,portNum)))
//                .proxyAuthenticator(authenticator)
//                .authenticator(authenticator)
//                .authenticator(new Authenticator() {
//                    @Override
//                    public Request authenticate(Route route, Response response) throws IOException {
//
////                        route.proxy().address().
//                        response.request().newBuilder()
//                                .header()
//
//
//
//                        return null;
//                    }
//                })

                .build();


//        ClearableCookieJar cookieJar =
//                new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context));

        Request request = new Request.Builder()

                .post(new RequestBody() {
                    @Override
                    public MediaType contentType() {
                        return null;
                    }

                    @Override
                    public void writeTo(BufferedSink bufferedSink) throws IOException {

                    }
                })
                .url("https://www.jianshu.com/search/do?q=" + keyWord + "&type=note&page=" + page + "&order_by=default")
//                .url("https://www.google.com.hk/?gws_rd=ssl")
//                .addHeader("host", "www.jianshu.com")
//                .addHeader("user-agent", "Charles/4.2.1")
//                .addHeader("content-type", "application/x-www-form-urlencoded")
//                .addHeader("authority", "www.jianshu.com")
//                .addHeader("method", "POST")
//                .addHeader("path", "/search/do?q=%E7%88%AC%E8%99%AB&type=note&page=4&order_by=default")
//                .addHeader("scheme", "https")
                .addHeader("accept", "application/json")
//                .addHeader("accept-language", "zh-CN,zh;q=0.8")
//                .addHeader("cache-control", "no-cache")
//                .addHeader("content-length", "0")
                .addHeader("cookie", "__yadk_uid=XK4YgHKZFyvXWlatec0rrAYKll0ZcDkF; OUTFOX_SEARCH_USER_ID_NCOO=241761522.23911893; signin_redirect=https%3A%2F%2Fwww.jianshu.com%2Fp%2Fa3d8d208d0d5; remember_user_token=W1szODE1NjkwXSwiJDJhJDEwJG9JdnFlSGdXcm9tMGl0VHQ3N2NjRS4iLCIxNTUyOTYxNzcwLjEwOTQ3OSJd--156328d991c51ec5ccc494bf53de9bac41f4d072; read_mode=day; default_font=font2; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%223815690%22%2C%22%24device_id%22%3A%22167721c822815f-088f17a91c6e07-34497b51-2073600-167721c82295f5%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_referrer%22%3A%22%22%2C%22%24latest_referrer_host%22%3A%22%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_utm_source%22%3A%22recommendation%22%2C%22%24latest_utm_medium%22%3A%22not-signed-in-user-follow-button%22%2C%22%24latest_utm_campaign%22%3A%22maleskine%22%2C%22%24latest_utm_content%22%3A%22note%22%7D%2C%22first_id%22%3A%22167721c822815f-088f17a91c6e07-34497b51-2073600-167721c82295f5%22%7D; Hm_lvt_0c0e9d9b1e7d617b3e6842e85b9fb068=1552462033,1552895244,1552899388,1552960270; Hm_lpvt_0c0e9d9b1e7d617b3e6842e85b9fb068=1552964917; ___rl__test__cookies=1552964923418; locale=zh-CN; _m7e_session_core=3f99e2bbf75487d89dc81d50ae4aefa7")
//                .addHeader("postman-token", "2e2eeb47-f087-ca08-e6f4-c5d7de759254")
//                .addHeader("authorization", Credentials.basic("root", "root"))
//                .addHeader("Proxy-Authorization", Credentials.basic("root", "root"))
                .build();

        try {

            for (int i = 0; i < 1; i++) {
                Thread.sleep(200);
                Response response = client.newCall(request).execute();
                result = response.body().string();
                System.out.println(i + ".response--->\n" + JSONParser.quote(result));


            }


        } catch (IOException e) {
            e.printStackTrace();
            result = e.getMessage();
        } catch (InterruptedException e) {
            result = e.getMessage();
            e.printStackTrace();
        }


        return result;
    }


}
