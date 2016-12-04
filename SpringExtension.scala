package com.akka.spring.util

import org.springframework.context.ApplicationContext
import akka.actor.Extension
import akka.actor.Props
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired
import scala.beans.BeanProperty

@Component("springExtension")
@Scope("singleton")
class SpringExtension extends Extension {
        @Autowired
        @BeanProperty var applicationContext:ApplicationContext=null ;
        def props(actorBeanName:String):Props= {
            return Props.create(
              classOf[SpringActorProducer], applicationContext, actorBeanName);
        }
    }
