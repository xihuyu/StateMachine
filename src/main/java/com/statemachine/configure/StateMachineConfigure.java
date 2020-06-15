package com.statemachine.configure;

import com.statemachine.constant.Event;
import com.statemachine.constant.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.*;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.transition.Transition;

import java.util.EnumSet;

/**
 * @version V1.0
 * @description: 配置
 * @author: fenggaopan
 * @date: 2020-06-15 09:32:06
 */
@Configuration
@EnableStateMachine
public class StateMachineConfigure extends EnumStateMachineConfigurerAdapter<State, Event> {

    private static final Logger LOGGER = LoggerFactory.getLogger(StateMachineConfigure.class);

    @Override
    public void configure(StateMachineStateConfigurer<State, Event> states) throws Exception {
        states.withStates()
                .initial(State.UNPAID)
                .states(EnumSet.allOf(State.class));
    }

//    @Bean
//    public StateMachineListener<State, Event> listener() {
//        return new StateMachineListenerAdapter<State, Event>() {
//            @Override
//            public void transition(Transition<State, Event> transition) {
//                if(transition.getTarget().getId() == State.UNPAID) {
//                    LOGGER.info("===========>订单创建,待支付");
//                }
//
//                if(transition.getSource().getId() == State.UNPAID && transition.getTarget().getId() == State.WAITING_FOR_RECEIVE) {
//                    LOGGER.info("===========>订单支付完成,待收货");
//                }
//
//                if(transition.getSource().getId() == State.WAITING_FOR_RECEIVE && transition.getTarget().getId() == State.DONE) {
//                    LOGGER.info("===========>订单确认收货完成,订单结束");
//                }
//            }
//        };
//    }


    @Override
    public void configure(StateMachineTransitionConfigurer<State, Event> transitions) throws Exception {
        transitions
                .withExternal()
                .source(State.UNPAID)
                .target(State.WAITING_FOR_RECEIVE)
                .and()
                .withExternal()
                .source(State.WAITING_FOR_RECEIVE)
                .target(State.DONE);
    }
}
