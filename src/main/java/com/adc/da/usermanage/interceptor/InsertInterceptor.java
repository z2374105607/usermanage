package com.adc.da.usermanage.interceptor;

import com.adc.da.util.utils.RequestUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.Properties;

@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {
                MappedStatement.class, Object.class })
})
public class InsertInterceptor implements Interceptor {

    private Properties properties;

    // 登录接口Path
    private static final String registerIFPath = "/api/cavd/private/systemUser/userRegiste";
    /*
     * (non-Javadoc)
     *
     * @see
     * org.apache.ibatis.plugin.Interceptor#intercept(org.apache.ibatis.plugin
     * .Invocation)
     */
    public Object intercept(Invocation invocation) throws Throwable {
        if (RequestContextHolder.getRequestAttributes() == null) {
            return invocation.proceed();
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        MappedStatement mappedStatement = (MappedStatement) invocation
                .getArgs()[0];
        String type=mappedStatement.getSqlCommandType().toString();
        String path = request.getServletPath();
        long userId=0;

        String id=mappedStatement.getId();
//        if( !StringUtils.isEmpty(id) && (id.contains("MenuEODao")||id.contains("FileEODao")|| id.contains("DicEODao")||id.contains("DicTypeEODao")||id.contains("MenuEODao")||id.contains("OrgEODao")||id.contains("RoleEODao")||id.contains("UserRoleEODao")||id.contains("LogEODao"))){
//            return invocation.proceed();
//        }
        if (!StringUtils.isEmpty(id) && (id.contains("FileEODao") || id.contains("UserOrgEODao") || id.contains("SubsystemApiEODao") || id.contains("OauthClientDetailsEODao") || id.contains("RoleAuthEODao") || id.contains("UserRoleDao"))) {
            return invocation.proceed();
        }
        if("INSERT".equals(type)){
            Object parameter = invocation.getArgs()[1];
            Object obj=request.getSession().getAttribute(RequestUtils.LOGIN_USER_ID);
            userId = Long.parseLong((String)obj);
//            if (registerIFPath.equals(path)) {
//                if ( parameter instanceof SystemUserEO) {
//                    userId = ((SystemUserEO)parameter).getId();
//                } else if (parameter instanceof UserEO){
//                    userId = Long.valueOf(((UserEO)parameter).getAccount());
//                }
//            } else {
//                Object obj=request.getSession().getAttribute(RequestUtils.LOGIN_USER_ID);
//                if (obj != null) {
//                    userId = Long.parseLong((String)obj);
//                }
//            }
            Field creatTime = parameter.getClass().getDeclaredField("createdAt");
            creatTime.setAccessible(true);
            creatTime.set(parameter, new Date());
            Field creatPerson = parameter.getClass().getDeclaredField("createdPerson");
            creatPerson.setAccessible(true);
            creatPerson.set(parameter,userId);
            Field updateTime = parameter.getClass().getDeclaredField("updatedAt");
            updateTime.setAccessible(true);
            updateTime.set(parameter, new Date());
            Field updatePerson = parameter.getClass().getDeclaredField("updatedPerson");
            updatePerson.setAccessible(true);
            updatePerson.set(parameter,userId);
        }else if("UPDATE".equals(type)){
//            if (id.contains("com.adc.da.sys.dao.UserEODao")) {
//                return invocation.proceed();
//            }
            Object parameter = invocation.getArgs()[1];
            Object obj=request.getSession().getAttribute(RequestUtils.LOGIN_USER_ID);
            userId = Long.parseLong((String)obj);
//            if (registerIFPath.equals(path)) {
//                userId = ((SystemUserEO)parameter).getId();
//            } else {
//                Object obj=request.getSession().getAttribute(RequestUtils.LOGIN_USER_ID);
//                if (obj != null) {
//                    userId = Long.parseLong((String)obj);
//                }
//            }
//            String name = parameter.getClass().getSuperclass().getName();
//            if (!("com.adc.da.base.entity.BaseEntity").equals(name)) {
//                return invocation.proceed();
//            }
            Field updateTime = parameter.getClass().getDeclaredField("updatedAt");
            updateTime.setAccessible(true);
            updateTime.set(parameter, new Date());
            Field updatePerson = parameter.getClass().getDeclaredField("updatedPerson");
            updatePerson.setAccessible(true);
            updatePerson.set(parameter,userId);
        }
        return invocation.proceed();

    }

    /*
     * (non-Javadoc)
     *
     * @see org.apache.ibatis.plugin.Interceptor#plugin(java.lang.Object)
     */
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.apache.ibatis.plugin.Interceptor#setProperties(java.util.Properties)
     */
    public void setProperties(Properties properties) {
        this.properties = properties;

    }

}