package com.designpattern.behavioral.command;

/*
 * Behavioral Design Patterns :- Are concerned with the interaction and responsibility of objects.
 * In these design patterns,the interaction between the objects should be in such a way that they can easily talk to each other
 * and still should be loosely coupled.
 * The implementation and the client should be loosely coupled in order to avoid hard coding and dependencies.
 *
 * Command Pattern :-		URL :- http://www.javatpoint.com/command-pattern
 * Encapsulate a request under an object as a command and pass it to invoker object.
 * Invoker object looks for the appropriate object which can handle this command and pass the
 * command to the corresponding object and that object executes the command.
 *
 * Advantage :-
 * It separates the object that invokes the operation from the object that actually performs the operation.
 * It makes easy to add new commands, because existing classes remain unchanged.
 *
 * Usage :-
 * When you need parameterize objects according to an action perform.
 * When you need to create and execute requests at different times.
 * When you need to support rollback, logging or transaction functionality.
 *
 * This interface will act as a Command. This is an interface for executing an operation.
 */

public interface ActionListenerCommand {
	public void exceute();
}