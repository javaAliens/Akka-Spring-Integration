package com.akka.spring.util

import org.springframework.context.ApplicationContext

import akka.actor.Actor
import akka.actor.IndirectActorProducer

/**
 * Every time you call a spring extension method , this particular producer
 * instance is create with the required constructor agrs and 
 * It returns an actor instance nothing but an object extending Actor 
 * trait of akka system.
 * 
 * A compaitable Props is provided to make this happen in akka.
 */
class SpringActorProducer(var applicationContext:ApplicationContext, 
       var beanActorName:String) extends IndirectActorProducer {
 
 
   override def produce():Actor= {
        return applicationContext.getBean(beanActorName).asInstanceOf[Actor];
    }
    override def actorClass():Class[_<: Actor]={
        return applicationContext
          .getType(beanActorName).asInstanceOf[Class[ _ <: Actor]];
    }
}