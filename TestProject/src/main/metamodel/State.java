package main.metamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;



public class State {
	private String name;
	private HashMap<String, List<Transition>> transitions = new HashMap<>();

	public State(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public List<Transition> getTransitions() {
		return transitions.values().stream().flatMap(List::stream).collect(Collectors.toList());
	}

	public Transition getTransitionByEvent(String eventName) {
		if(!transitions.containsKey(eventName)) return null;

		return transitions.get(eventName).stream().findFirst().orElse(null);
	}

	public List<Transition> getTransitionsByEvent(String eventName) {
		if(!transitions.containsKey(eventName)) return new ArrayList<>();

		return new ArrayList<>(transitions.get(eventName));
	}

	public void addTransition(String eventName, Transition transition) {
		if(!transitions.containsKey(eventName)) transitions.put(eventName, new ArrayList<>());

		this.transitions.get(eventName).add(transition);
	}
}
