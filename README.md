# Verification course work

## Simple ltl formula verificator 
Checks LTL formulas against given models.

See the detailed description [here](https://docs.google.com/document/d/1nUaRnyy4cL5SgwDCfFBZLZiXETVISTsDWTk6-gUnEsk/edit)

## Usage:
```
java -jar verification.jar <mode: batch|single> <ltl: formula or file.ltl> <automaton.xstd> <result.out>
```
Application has 4 required args:
 - mode: either ``batch`` (for processing file) or ``single`` (for one ltl formula)
 - ltl: either single ltl-formula to be verified or path to file with ltl-formulas
 - automaton.xstd: file with automaton for ltl-formula to be checked on
 - result.out: file for verification result to be written into
 
 
## ltl2ba
Ltl2ba library used to convert LTL formula to Buchi Automaton.

-   LTL formula:
 
        false
      
    Buchi Automaton:
      
        never {    /* false */
        T0_init:
            false;
        }


-   LTL formula:
    
        S(state0)
    
    Buchi Automaton:
    
        never { /* v0 */
        accept_init:
            if
            :: (v0) -> goto accept_all
            fi;
        accept_all:
            skip
        } 


## Working stages

Formula and it's negation automaton:
```
S(state0)
Automaton(initialState=0, nodes=[0, 1], acceptingSet=[0, 1], transitions={0={S(state0)=[1]}, 1={true=[1]}})
```

A diagram from [ATransition.xstd](src/main/resources/diagrams/ATransition.xstd) and it's automaton
```
Diagram(name=ATransition, data=Data(stateMachine=StateMachine(events=null, autoreject=false)), widget=[Widget(id=0, type=State, attributes=Attributes(name=state0, type=1, code=null, guard=null, incomings=[Incoming(id=3), Incoming(id=9)], outgoings=[Outgoing(id=2), Outgoing(id=5)], actions=null, event=null, nested=null)), Widget(id=3, type=Transition, attributes=Attributes(name=null, type=null, code=null, guard=, incomings=null, outgoings=null, actions=[Action(name=SetID, comment=)], event=Event(name=number, comment=), nested=null)), Widget(id=9, type=Transition, attributes=Attributes(name=null, type=null, code=null, guard=, incomings=null, outgoings=null, actions=[Action(name=SetName, comment=)], event=Event(name=quote, comment=We see quotation symbol), nested=null)), Widget(id=2, type=Transition, attributes=Attributes(name=null, type=null, code=null, guard=, incomings=null, outgoings=null, actions=null, event=Event(name=id, comment=We see the word "id"), nested=null)), Widget(id=5, type=Transition, attributes=Attributes(name=null, type=null, code=null, guard=, incomings=null, outgoings=null, actions=null, event=Event(name=labelString, comment=We see a keyword "labelString"), nested=null)), Widget(id=1, type=State, attributes=Attributes(name=StateID, type=0, code=null, guard=null, incomings=[Incoming(id=2)], outgoings=[Outgoing(id=3)], actions=null, event=null, nested=null)), Widget(id=4, type=State, attributes=Attributes(name=StartLabel, type=0, code=null, guard=null, incomings=[Incoming(id=5)], outgoings=[Outgoing(id=7)], actions=null, event=null, nested=null)), Widget(id=7, type=Transition, attributes=Attributes(name=null, type=null, code=null, guard=, incomings=null, outgoings=null, actions=[Action(name=ClearText, comment=)], event=Event(name=quote, comment=We see quotation symbol), nested=null)), Widget(id=6, type=State, attributes=Attributes(name=SLabel, type=0, code=null, guard=null, incomings=[Incoming(id=7), Incoming(id=8)], outgoings=[Outgoing(id=8), Outgoing(id=9)], actions=null, event=null, nested=null)), Widget(id=8, type=Transition, attributes=Attributes(name=null, type=null, code=null, guard=, incomings=null, outgoings=null, actions=[Action(name=AddToken, comment=)], event=Event(name=*, comment=No event), nested=null))])
Automaton(initialState=100000, nodes=[0, 100001, 100000, 1, 100003, 100002, 4, 100005, 100004, 6, 100007, 100006, 100009, 100008, 100010], acceptingSet=[0, 100001, 100000, 1, 100003, 100002, 4, 100005, 100004, 6, 100007, 100006, 100009, 100008, 100010], transitions={100001={S(StateID)=[1]}, 0={E(id)=[100001], E(labelString)=[100002]}, 1={E(number)=[100003]}, 100000={S(state0)=[0]}, 100003={A(SetID)=[100004]}, 100002={S(StartLabel)=[4]}, 100005={A(ClearText)=[100006]}, 4={E(quote)=[100005]}, 100004={S(state0)=[0]}, 100007={A(AddToken)=[100008]}, 6={E(*)=[100007], E(quote)=[100009]}, 100006={S(SLabel)=[6]}, 100009={A(SetName)=[100010]}, 100008={S(SLabel)=[6]}, 100010={S(state0)=[0]}})
```

Intersection of both automatons:

```
Automaton(initialState=0, nodes=[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47], acceptingSet=[2, 3, 6, 7, 9, 11, 13, 14, 16, 19, 20, 23, 25, 26, 29, 30, 32, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47], transitions={0={S(state0)=[6]}, 1={S(StateID)=[2]}, 2={E(number)=[10]}, 3={S(StateID)=[4]}, 4={E(number)=[9]}, 5={E(id)=[3], E(labelString)=[7]}, 6={E(id)=[1], E(labelString)=[8]}, 7={S(StartLabel)=[17]}, 8={S(StartLabel)=[16]}, 9={A(SetID)=[15]}, 10={A(SetID)=[14]}, 11={S(state0)=[5]}, 12={S(state0)=[6]}, 13={S(state0)=[5]}, 14={S(state0)=[5]}, 15={S(state0)=[6]}, 16={E(quote)=[18]}, 17={E(quote)=[20]}, 18={A(ClearText)=[19]}, 19={S(SLabel)=[28]}, 20={A(ClearText)=[21]}, 21={S(SLabel)=[29]}, 22={S(state0)=[6]}, 23={S(state0)=[5]}, 24={A(AddToken)=[25]}, 25={S(SLabel)=[28]}, 26={A(AddToken)=[27]}, 27={S(SLabel)=[29]}, 28={E(*)=[26], E(quote)=[30]}, 29={E(*)=[24], E(quote)=[31]}, 30={A(SetName)=[33]}, 31={A(SetName)=[32]}, 32={S(state0)=[5]}, 33={S(state0)=[6]}, 34={S(state0)=[6]}, 35={S(state0)=[5]}})
```

If that automaton accepts some word, then  this word will be a counter example for the given formula, thus proving that formula if wrong on that model. 


## Resources
[book1](reference/1klark_e_m_gramberg_o_peled_d_verifikatsiya_modeley_programm.djvu)

[book2](reference/velder_verification_posobie_nauka.pdf)