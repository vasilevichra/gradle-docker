package se.transmode.gradle.plugins.docker

import groovy.transform.TupleConstructor
import groovy.util.logging.Log
import org.gradle.api.logging.Logger
import org.gradle.api.logging.Logging
import se.transmode.gradle.plugins.docker.image.Dockerfile

@TupleConstructor
@Log
class LegacyDockerfileMethods implements GroovyInterceptable {

    private static Logger logger = Logging.getLogger(LegacyDockerfileMethods)
    Dockerfile dockerfile

    def invokeMethod(String name, args) {
        logger.warn('The {} method has been deprecated and is scheduled to be removed. Use the new dockerfile API instead.', name)
        metaClass.getMetaMethod(name, args).invoke(this, args)
    }

    /**
     * Set the default command of the Docker image ('CMD' in Dockerfile). Deprecated.
     *
     * Use the new dockerfile API instead:
     *   dockerfile {
     *     cmd 'your-command'
     *   }
     *
     */
    @Deprecated
    void setDefaultCommand(List cmd) {
        dockerfile.cmd(cmd)
    }

    /**
     * Set the default command of the Docker image ('CMD' in Dockerfile). Deprecated.
     *
     * Use the new dockerfile API instead:
     *   dockerfile {
     *     cmd 'your-command'
     *   }
     *
     */
    @Deprecated
    void defaultCommand(List cmd) {
        dockerfile.cmd(cmd)
    }

}
