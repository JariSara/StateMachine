package main.metamodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Machine {
	private List<State> states = new ArrayList<State>();
	private HashMap<String, Integer> integers = new HashMap<String, Integer>();
	private State initialState;
	private State currentState;
	public Machine(Collection<State> states, State initialState) {
		super();
		this.states.addAll(states);
		this.initialState = initialState;
	}
	public List<State> getStates() {
		return states;
	}

	public State getInitialState() {
		return initialState;
	}
	public HashMap<String, Integer> getIntegers(){
		return this.integers;
	}
	public State getCurrentState() {
		return this.currentState;
	}
	public State getState(String string) {
		int target=0;
		for(int i=0; i<states.size();i++){
			if(states.get(i).toString()==string) {
				target = i;
			}
		}
		return states.get(target);
	}

	public int numberOfIntegers() {
		return integers.size();
	}

	public boolean hasInteger(String string) {
		return integers.containsKey(string);
	}

	public void setCurrentState(State state) {
		this.currentState = state;
	}
}
