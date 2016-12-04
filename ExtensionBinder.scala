package com.akka.spring.util

import akka.actor.AbstractExtensionId
import akka.actor.ExtendedActorSystem
import akka.actor.ActorSystem
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired
import scala.beans.BeanProperty

@Component("extensionBinder")
@Scope("singleton")
class ExtensionBinder extends AbstractExtensionId[SpringExtension] {
 
  @Autowired
  @BeanProperty var springExtension:SpringExtension=null;
  
    @Override
      def createExtension(system:ExtendedActorSystem) :SpringExtension={
        return springExtension;
    }
    
    override def get(actorSystem:ActorSystem):SpringExtension={
      super.get(actorSystem)
    }
}