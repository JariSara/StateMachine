package main.metamodel;

import main.metamodel.Transition.ConditionalType;
import main.metamodel.Transition.OperationType;

public class Transition {

	private State target;
	private String eventName;
	private OperationType operationType = OperationType.NONE;

	private ConditionalType conditionalType = ConditionalType.NONE;
	private String operationVariableName;
	private String conditionVariableName;
	private int operationValue = 0;
	private int comparedValue = 0;
	private int setValue = 0;

	public Transition(String eventName) {
		this.eventName = eventName;
	}

	public String getEvent() {
		return this.eventName;
	}

	public State getTarget() {
		return this.target;
	}

	public void setTarget(State state) {
		this.target = state;
	}

	public boolean hasSetOperation() {
		return operationType == OperationType.SET;
	}

	public boolean hasIncrementOperation() {
		return operationType == OperationType.INCREMENT;
	}

	public boolean hasDecrementOperation() {
		return operationType == OperationType.DECREMENT;
	}

	public String getOperationVariableName() {
		return operationVariableName;
	}

	public boolean isConditional() {
		return conditionalType != ConditionalType.NONE;
	}

	public ConditionalType getConditionalType() {
		return this.conditionalType;
	}

	public String getConditionVariableName() {
		return conditionVariableName;
	}

	public Integer getConditionComparedValue() {
		return comparedValue;
	}

	public boolean isConditionEqual() {
		return conditionalType == ConditionalType.EQUALS;
	}

	public boolean isConditionGreaterThan() {
		return conditionalType == ConditionalType.GREATER_THAN;
	}

	public boolean isConditionLessThan() {
		return conditionalType == ConditionalType.LESS_THAN;
	}

	public boolean hasOperation() {
		return operationType != OperationType.NONE;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

	public void setConditionalType(ConditionalType conditional) {
		this.conditionalType = conditional;
	}

	public void setOperationVariableName(String operationVariableName) {
		this.operationVariableName = operationVariableName;
	}

	public void setConditionVariableName(String conditionVariableName) {
		this.conditionVariableName = conditionVariableName;
	}

	public void setOperationValue(int operationValue) {
		this.operationValue = operationValue;
	}

	public void setComparedValue(int comparedValue) {
		this.comparedValue = comparedValue;
	}

	public String getEventName() {
		return eventName;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public int getOperationValue() {
		return operationValue;
	}

	public int getComparedValue() {
		return comparedValue;
	}

	public int getSetValue() {
		return setValue;
	}

	public void setSetValue(int setValue) {
		this.setValue = setValue;
	}

	public enum OperationType {
		NONE, INCREMENT, DECREMENT, SET
	}

	public enum ConditionalType {
		NONE, LESS_THAN, GREATER_THAN, EQUALS
	}
}
