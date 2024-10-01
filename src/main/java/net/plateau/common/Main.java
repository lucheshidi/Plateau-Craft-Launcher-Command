package net.plateau.common;

import org.apache.commons.cli.*;
import org.apache.log4j.Logger;

public class Main {

    static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args)
    {
        //创建Options对象，用于定义命令行参数
        Options options = new Options();

        //创建Help方法
        Option help = new Option("?", "help", false, "?");
        options.addOption(help);

        Option version = new Option("v", "version", false, "ver");
        options.addOption(version);

        Option launch = new Option("l", "launch", true, "launch");
        options.addOption(launch);

        Option download = new Option("d", "download", true, "download");
        options.addOption(download);

        Option list = new Option("list", "list", false, "list");
        options.addOption(list);

        Option changedir = new Option("cd", "changedir", true, "cd");
        options.addOption(changedir);

        // 创建命令行解析器
        CommandLineParser parser = new DefaultParser();
        try
        {
            // 解析命令行参数
            CommandLine cmd = parser.parse(options, args);

            // 检查是否有版本参数
            if (cmd.hasOption("version"))
            {
                System.out.println("net.plateau.MainCom version:0.1.0");
                System.out.println("Project: https://github.com/lucheshidi/plateau");
            }

            // 检查是否启动游戏
            if (cmd.hasOption("launch"))
            {
                logger.info("Please input version, if not had version, please use -d or -download");
            }

            //检查是否列出游戏版本
            if (cmd.hasOption("list"))
            {
                logger.info("listing versions...");
                //列出版本
            }

            //下载
            if (cmd.hasOption("download"))
            {
                logger.info("Please input version, if not had version, please use -d or -download");
            }

            //检查是否帮助
            if (cmd.hasOption("help"))
            {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("net.plateau.MainCom", options);
            }

        } catch (ParseException e)
        {
            throw new RuntimeException(e);
        }
    }
}
