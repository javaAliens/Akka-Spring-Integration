package com.akka.spring.actor

import scala.beans.BeanProperty

class ActorMessage {
  @BeanProperty var message : String=null;
}