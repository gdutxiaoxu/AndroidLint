package com.rocketzly.lintplugin.executor

/**
 * User: Rocket
 * Date: 2020/9/8
 * Time: 6:57 PM
 */
class Py3Executor : ScriptExecutor.Executor {
    override fun exec(
        scriptPath: String,
        reportPath: String,
        userName: String,
        moduleName: String,
        errorCount: Int,
        errorSummary: HashSet<String>
    ) {
        val command =
            "python3 $scriptPath --reportPath=$reportPath --userName=$userName --moduleName=$moduleName --errorCount=$errorCount"
        println("执行命令如下：")
        println(command)
        val process = Runtime.getRuntime().exec(command)

        val stdout = String(process.inputStream.readBytes(), Charsets.UTF_8).removeSuffix("\n")
        val stderr = String(process.errorStream.readBytes(), Charsets.UTF_8).removeSuffix("\n")
        println()
        println("执行日志如下：")
        if (stdout.isNotEmpty()) {
            println("stdout:")
            println(stdout)
        }
        if (stderr.isNotEmpty()) {
            println("stderr:")
            println(stderr)
        }
    }


}