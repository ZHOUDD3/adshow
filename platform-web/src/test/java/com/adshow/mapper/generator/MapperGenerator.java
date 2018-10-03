package com.adshow.mapper.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import javax.swing.filechooser.FileSystemView;

public class MapperGenerator {

    private static String desktopDir = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();


    public static void main(String[] args) {
        //生成权限代码
//        genCode("E:" + "\\code\\20180813", new String[]{"sys_"}, new String[]{"sys_resource_player","sys_user_resource","sys_resource"});
        //生成广告代码
        genCode(desktopDir + "\\code\\auth", new String[]{"ad_"}, new String[]{"ad_subtitle"});

    }

    /**
     * @param genPath      生成路径
     * @param tablePrefix  表前缀
     * @param includeTable 包含的表
     */
    public static void genCode(String genPath, String[] tablePrefix, String[] includeTable) {
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(genPath);
        gc.setAuthor("wmz");
        gc.setFileOverride(true); //是否覆盖
        gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList

        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("I%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert() {
            // 自定义数据库表字段类型转换
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                return super.processTypeConvert(fieldType);
            }
        });
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/adshow?characterEncoding=utf8");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setCapitalMode(false);
        strategy.setTablePrefix(tablePrefix);// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(includeTable);
        strategy.setSuperEntityClass("com.adshow.mybatis.entity.BaseEntity");
        strategy.setSuperEntityColumns(new String[]{"id", "create_time", "update_time", "create_user", "update_user", "version"});
        strategy.setSuperControllerClass("com.adshow.core.common.controller.BaseController");
        strategy.setRestControllerStyle(true);
        strategy.setVersionFieldName("version");
        strategy.setEntityLombokModel(false);
        strategy.entityTableFieldAnnotationEnable(true);
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);

        strategy.setEntityBuilderModel(true);
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.adshow");
        pc.setModuleName("auth");
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("mapper");
        pc.setXml("mapper.mapping");

        mpg.setPackageInfo(pc);

        // 执行生成
        mpg.execute();

    }


}
