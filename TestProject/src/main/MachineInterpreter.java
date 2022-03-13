package main;

import main.metamodel.Transition;
import main.metamodel.Machine;
import main.metamodel.State;

public class MachineInterpreter {
	private Machine machine;
	private State currentState;
	public void run(Machine m) {
		this.machine = m;
		this.currentState = machine.getInitialState();
	}

	public State getCurrentState() {
		return this.currentState;
	}

	public void processEvent(String event) {
		for(Transition t: currentState.getTransitions()) {
			if(t != null) {
				if(t.getOperationType() != Transition.OperationType.NONE) {
					t.setOperationValue(getInteger(t.getOperationVariableName()));
				}
				if(isConditionTrue(t)) {
					executeTransition(t);
					return;
				}
			}
		}
		
	}

	private boolean isConditionTrue(Transition transition) {
		if (transition == null) return false;
		if (!transition.isConditional()) return true;

		int value = getInteger(transition.getConditionVariableName());

		return switch (transition.getConditionalType()) {
			case EQUALS -> transition.getConditionComparedValue() == value;
			case GREATER_THAN -> transition.getConditionComparedValue() < value;
			case LESS_THAN -> transition.getConditionComparedValue() > value;
			default -> true;
		};
	}

	private void executeTransition(Transition transition) {
		switch (transition.getOperationType()) {
			case SET -> machine.getIntegers().put(transition.getOperationVariableName(), transition.getSetValue());
			case DECREMENT -> machine.getIntegers().put(transition.getOperationVariableName(), transition.getOperationValue()-1);
			case INCREMENT -> machine.getIntegers().put(transition.getOperationVariableName(), transition.getOperationValue()+1);
		}

		machine.setCurrentState(transition.getTarget());
	}

	public int getInteger(String string) {
		return machine.getIntegers().get(string);
	}

}
