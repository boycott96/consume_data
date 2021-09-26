package com.jrhl.api;

import com.jrhl.config.httpclient.HttpClientService;
import com.jrhl.constant.ApiEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class ConsumeApi {

    private final HttpClientService httpClientService;

    @Autowired
    public ConsumeApi(HttpClientService httpClientService) {
        this.httpClientService = httpClientService;
    }

    public void getRemoteConsumeData() {
        Header[] headers = new Header[]{
                new BasicHeader("cookie", "gr_user_id=461ecadc-34d8-4c6d-89b8-a5c719b11add; passport_csrf_token_default=c66bdda6bee06f72b8787d60ce39f67f; passport_csrf_token=c66bdda6bee06f72b8787d60ce39f67f; grwng_uid=014e4a7f-a2bc-476b-b57c-854ddfe53416; _ga=GA1.2.1437677536.1630663870; _ga_2M3R5Z77SJ=GS1.1.1630663869.1.1.1630663979.0; ttcid=2318f8b73e9b48c9a001317629947bbe23; n_mh=9-mIeuD4wZnlYrrOvfzG3MuT6aQmCUtmr8FxV8Kl8xY; odin_tt=fe797fddb27ada7786765cf75d4d557fe3c4b23a8205c85c378b6c3465c77f63108d116f0c79191e4ca0f9c656c6360cbbe4294bd938327f5c10a1c5b95f29a3; sso_uid_tt=39aa3f03282c9f3da8794dc9f69c6c19; sso_uid_tt_ss=39aa3f03282c9f3da8794dc9f69c6c19; toutiao_sso_user=8ab81e26e044aff350281fabbb336790; toutiao_sso_user_ss=8ab81e26e044aff350281fabbb336790; tt_scid=RehwHT-hQ0TQ6nzketFj8k458kueCrw8ISsE9S44l5bE9nygbOX6OZVRZkDxgjym0bbd; MONITOR_WEB_ID=239304; sid_ucp_v1=1.0.0-KDQ5ZWZkYTRmZTQzNmRiMGJkOWZlOGQ5OTE1NzQ1YzdlZTRkZGI2NTkKCBC2nMCKBhgNGgJsZiIgYjZlNGI3ZTQ3OTgzZjQyNDg4YzhjYmQwYjQxYTExNDc; ssid_ucp_v1=1.0.0-KDQ5ZWZkYTRmZTQzNmRiMGJkOWZlOGQ5OTE1NzQ1YzdlZTRkZGI2NTkKCBC2nMCKBhgNGgJsZiIgYjZlNGI3ZTQ3OTgzZjQyNDg4YzhjYmQwYjQxYTExNDc; s_v_web_id=ku0tlm0g_gAzAvXLs_6dxL_4HyL_8Kek_Sx0JS2Tfl0XC; uid_tt=39aa3f03282c9f3da8794dc9f69c6c19; uid_tt_ss=39aa3f03282c9f3da8794dc9f69c6c19; sid_tt=8ab81e26e044aff350281fabbb336790; sessionid=8ab81e26e044aff350281fabbb336790; sessionid_ss=8ab81e26e044aff350281fabbb336790; sid_guard=8ab81e26e044aff350281fabbb336790%7C1632636474%7C4501176%7CWed%2C+17-Nov-2021+08%3A27%3A30+GMT; gftoken=OGFiODFlMjZlMHwxNjMyNjM3ODk5ODZ8fDAGBgYGBgY")
        };
        Map<String, Object> map = new HashMap<>();
        map.put("endDate", "2021-09-25");
        map.put("page", "1");
        map.put("size", 10);
        map.put("startDate", "2021-09-25");
        CloseableHttpResponse response;
        try {
            response = httpClientService.doGet(ApiEnum.GET_CONSUME_DATA.getApi(), headers, map);
            if (response != null) {
                log.info("状态：" + response.getStatusLine());
                String str = EntityUtils.toString(response.getEntity(), "UTF-8");
                log.info("内容：" + str);
                if (str.contains("<!doctype html>")) {
                    // 此时cookie失效。需要重新登录获取cookie
                    // 将结果反馈到数据库中
                    log.info("反馈到数据库中");
                    // todo
                }
            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
