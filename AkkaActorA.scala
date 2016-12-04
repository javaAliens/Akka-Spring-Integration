package com.akka.spring.actor

import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired
import akka.actor.Actor
import scala.beans.BeanProperty

@Component("actorA")
@Scope("prototype")
class AkkaActorA extends Actor{
  
  @Autowired
  @BeanProperty var messageA:ActorMessage=null;
  override def receive ={
    case _ =>{
      println(messageA.message)
    }
  }
}