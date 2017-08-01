package cn.ykchen.utils.enums.mybatis;

import cn.ykchen.utils.enums.EnumDescAndCode;
import org.apache.ibatis.io.ResolverUtil;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.Set;

import static org.springframework.util.StringUtils.hasLength;
import static org.springframework.util.StringUtils.tokenizeToStringArray;

/**
 * Created by yk.chen on 2017/5/18.
 */
public class EnumDescAndCodeFactoryBean extends SqlSessionFactoryBean {

    private static final Log LOGGER = LogFactory.getLog(EnumDescAndCodeFactoryBean.class);

    public String enumsPackage;

    protected SqlSessionFactory buildSqlSessionFactory() throws IOException{

        SqlSessionFactory sessionFactory = super.buildSqlSessionFactory();
        TypeHandlerRegistry typeHandlerRegistry = sessionFactory.getConfiguration().getTypeHandlerRegistry();
        if (hasLength(this.enumsPackage)) {
            String[] enumsArray = tokenizeToStringArray(this.enumsPackage,
                    ConfigurableApplicationContext.CONFIG_LOCATION_DELIMITERS);
            for (String packageToScan : enumsArray) {
                register(packageToScan,typeHandlerRegistry);
                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("Scanned package: '" + packageToScan + "' for EnumDescAndCode");
                }
            }
        }
        return sessionFactory;
    }

    public String getEnumsPackage() {
        return enumsPackage;
    }

    public void setEnumsPackage(String enumsPackage) {
        this.enumsPackage = enumsPackage;
    }

    /**
     * 注册typeHandler
     * @param packageName
     * @param typeHandlerRegistry
     */
    private void register(String packageName,TypeHandlerRegistry typeHandlerRegistry) {
        ResolverUtil<Class<?>> resolverUtil = new ResolverUtil<Class<?>>();
        resolverUtil.find(new ResolverUtil.IsA(EnumDescAndCode.class), packageName);
        Set<Class<? extends Class<?>>> enumSet = resolverUtil.getClasses();
        for (Class<?> type : enumSet) {
            //Ignore inner classes and interfaces (including package-info.java) and abstract classes
            if (!type.isAnonymousClass() && !type.isInterface() && !Modifier.isAbstract(type.getModifiers())) {
                typeHandlerRegistry.register(type,null,EnumDescAndCodeTypeHandler.class);
            }
        }
    }
}
