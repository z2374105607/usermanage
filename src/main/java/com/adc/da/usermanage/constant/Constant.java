package com.adc.da.usermanage.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2018/10/19.
 */
@Component
public class Constant {

    public static  String GROUP_AUTH_CLIENT_CLIENTID;

    public static  String GROUP_AUTH_CLIENT_CLIENTSECRET;

    public static  String GROUP_OPENAPI_SERVER;

    public static  String GROUP_OPENAPI_URL_GETUSERINFO;

    public static String GROUP_OPENAPI_URL_GETROOTLIST;

    public static String GROUP_OPENAPI_URL_GETSUBNODES;

    @Value("${group.openapi.server}")
    public  void setGroupOpenapiServer(String groupOpenapiServer) {
        GROUP_OPENAPI_SERVER = groupOpenapiServer;
    }

    @Value("${group.openapi.url.GetUserInfo}")
    public void setGroupOpenapiUrlGetUserInfo(String groupOpenapiUrlGetUserInfo) {
        GROUP_OPENAPI_URL_GETUSERINFO = groupOpenapiUrlGetUserInfo;
    }

    @Value("${group.openapi.url.GetRootList}")
    public void setGroupOpenapiUrlGetRootList(String groupOpenapiUrlGetRootList) {
        GROUP_OPENAPI_URL_GETROOTLIST = groupOpenapiUrlGetRootList;
    }

    @Value("${group.openapi.url.GetSubNodes}")
    public void setGroupOpenapiUrlGetSubNodes(String groupOpenapiUrlGetSubNodes) {
        GROUP_OPENAPI_URL_GETSUBNODES = groupOpenapiUrlGetSubNodes;
    }

    @Value("${group.auth.client.clientId}")
    public  void setGroupAuthClientClientid(String groupAuthClientClientid) {
        GROUP_AUTH_CLIENT_CLIENTID = groupAuthClientClientid;
    }

    @Value("${group.auth.client.clientSecret}")
    public  void setGroupAuthClientClientsecret(String groupAuthClientClientsecret) {
        GROUP_AUTH_CLIENT_CLIENTSECRET = groupAuthClientClientsecret;
    }
}
