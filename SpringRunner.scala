package com.akka.spring.runner

import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Scope
import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.stereotype.Component

import com.akka.spring.util.ExtensionBinder

import akka.actor.ActorSystem
import akka.actor.actorRef2Scala
import com.akka.spring.util.SpringExtension

object SpringRunner {
  def main(args:Array[String])
  {
   
     val applicationContext:ApplicationContext=new ClassPathXmlApplicationContext("ApplicationContext.xml");
     println(applicationContext);
     var actorSystem = applicationContext.getBean("actorSystem").asInstanceOf[ActorSystem]
     var extensionBinder= applicationContext.getBean("extensionBinder").asInstanceOf[ExtensionBinder]
     var springExtension= applicationContext.getBean("springExtension").asInstanceOf[SpringExtension]

     var actorA=actorSystem.actorOf(extensionBinder(actorSystem).props("actorA"),"actorA");
     var actorB=actorSystem.actorOf(extensionBinder(actorSystem).props("actorB"),"actorB");
    
     /*var actorA=actorSystem.actorOf(springExtension.props("actorA"),"actorA");
     var actorB=actorSystem.actorOf(springExtension.props("actorB"),"actorB");*/
    
     actorA ! "Hello"
     actorB ! "Hello"
     
     Thread.sleep(5000);
     println("Shutting down actor system");
     actorSystem.terminate();
     println("Babye");
  }
}