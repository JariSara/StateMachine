package main;

import java.util.HashMap;
import java.util.Map;

import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.Transition;

public class StateMachine {
	private Map<String,State> states = new HashMap<>();
	
	private State currentState;
	private State initial;
	private Transition currentTrans;
	private String currentEvent;
	private HashMap<String, Integer> variables = new HashMap<>();
	private HashMap<Transition, String> transitionTargets = new HashMap<>();
	public Machine build() {
		return new Machine(states.values(),initial); 
	}
	private State getState(String name) {
		if(!states.containsKey(name)) states.put(name, new State(name));
		return states.get(name);
	}
	public StateMachine state(String name) {
		currentState = getState(name);
		return this;
	}

	public StateMachine initial() {
		initial=currentState;
		return this;
	}

	public StateMachine when(String name) {
		currentTrans = new Transition(name);
		currentTrans.setTarget(currentState);
		this.currentState.addTransition(name, currentTrans);
		return this;
	}

	public StateMachine to(String string) {
		transitionTargets.put(currentTrans, string);
		return this;
	}

	public StateMachine integer(String string) {
		variables.put(string, 0);
		return this;
	}

	public StateMachine set(String string, int i) {
		currentTrans.setOperationType(Transition.OperationType.SET);
		currentTrans.setSetValue(i);
		currentTrans.setOperationVariableName(string);
		return this;
	}

	public StateMachine increment(String string) {
		currentTrans.setOperationType(Transition.OperationType.INCREMENT);
		currentTrans.setOperationVariableName(string);
		return this;
	}

	public StateMachine decrement(String string) {
		currentTrans.setOperationType(Transition.OperationType.DECREMENT);
		currentTrans.setOperationVariableName(string);
		return this;
	}

	public StateMachine ifEquals(String string, int i) {
		currentTrans.setConditionalType(Transition.ConditionalType.EQUALS);
		currentTrans.setConditionVariableName(string);
		currentTrans.setComparedValue(i);
		return this;
	}

	public StateMachine ifGreaterThan(String string, int i) {
		currentTrans.setConditionalType(Transition.ConditionalType.GREATER_THAN);
		currentTrans.setConditionVariableName(string);
		currentTrans.setComparedValue(i);
		return this;
	}

	public StateMachine ifLessThan(String string, int i) {
		currentTrans.setConditionalType(Transition.ConditionalType.LESS_THAN);
		currentTrans.setConditionVariableName(string);
		currentTrans.setComparedValue(i);
		return this;
	}

}
