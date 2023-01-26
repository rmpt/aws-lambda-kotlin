package com.ruimptech.echo

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.LambdaLogger
import com.amazonaws.services.lambda.runtime.RequestHandler

class App : RequestHandler<EchoIn, EchoOut> {
    override fun handleRequest(input: EchoIn, context: Context): EchoOut {
        val logger: LambdaLogger = context.logger
        logger.log("ECHO INPUT RECEIVED: " + input.content)
        return EchoOut("Echo: ${input.content}")
    }
}