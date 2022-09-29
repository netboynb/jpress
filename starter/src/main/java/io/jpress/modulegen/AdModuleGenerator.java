package io.jpress.modulegen;

import io.jpress.codegen.ModuleGenerator;

/**
 * @创建人 netboy
 * @创建时间 2022/9/28
 * @描述
 */
public class AdModuleGenerator {
    private static String dbUrl = "jdbc:mysql://127.0.0.1:3306/jpress_db";
    private static String dbUser = "root";
    private static String dbPassword = "123456";

    private static String moduleName = "ad";
    private static String dbTables = "ad";
    private static String optionsTables = "ad";
    private static String sortTables = "ad";
    private static String sortOptionsTables = "ad";
    private static String modelPackage = "io.jpress.module.ad.model";
    private static String servicePackage = "io.jpress.module.ad.service";


    public static void main(String[] args) {

        ModuleGenerator moduleGenerator = new ModuleGenerator(moduleName, dbUrl, dbUser, dbPassword, dbTables, optionsTables,sortTables,sortOptionsTables, modelPackage, servicePackage);
        moduleGenerator.setGenUI(true).gen();

    }
}
