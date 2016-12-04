package com.akka.spring.actor

import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import scala.beans.BeanProperty
import akka.actor.Actor
import org.springframework.beans.factory.annotation.Autowired

@Component("actorB")
@Scope("prototype")
class AkkaActorB extends Actor{
  
  @Autowired
  @BeanProperty var messageB:ActorMessage=null;
  override def receive ={
    case _ =>{
      println(messageB.message)
    }
  }
}