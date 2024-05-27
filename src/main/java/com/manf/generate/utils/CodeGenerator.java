package com.manf.generate.utils;




import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * 代码生成器 ~~
 * by 满风`
 * @since 2022.8.26
 */

public class CodeGenerator {
    public static void main(String[] args) {
            generate();
    }


    private static void  generate(){
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/db_authority_system?serverTimezone=GMT%2b8", "root", "199906")
                .globalConfig(builder -> {
                    builder.author("manfeng") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir("D:\\JavaProject\\generate\\src\\main\\java\\"); // 指定输出目录

                })
                .packageConfig(builder -> {
                    builder.parent("com.manf.generate") // 设置父包名
                            .moduleName(null) // 设置父包模块名 没有为空
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\JavaProject\\generate\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.entityBuilder().enableLombok();
                    builder.controllerBuilder().enableHyphenStyle()// 开启驼峰转连字符
                            .enableRestStyle()  // 开启生成@RestController 控制器
                            .serviceBuilder().formatServiceFileName("%sService")  //去掉service中的I
                            .formatServiceImplFileName("%sServiceImp");
                    builder.addInclude("sys_department") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀

                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}
