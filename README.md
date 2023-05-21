# README.md
## Application consists of 3 modules - each for another task of ING Green Code Copmpetition

### atmservice
A system that will prepare the appropriate order of orders to be handled for the convoy group. Convoy travels on prepared route and needs to handle orders based on priority:

### onlinegame
An algorithm for online game that, for a given number of group seats and clans, along with its number and total number of points, determines the order and arrangement in which players should enter the board.

### transactions
An algorithm that for a given list of transactions processes them all and returns a sorted list of accounts, along with the number of credits and debits and the ending balance.

# SAST analysis by SpotBugs

[SpotBugs](https://spotbugs.github.io/) Report
==============================================

Project Information
-------------------

Project: IngGreenCode

SpotBugs version: 4.7.3

Code analyzed:

*   D:\\java\\ing




Metrics
-------

0 lines of code analyzed, in 0 classes, in 4 packages.

Metric

Total

Density\*

High Priority Warnings

0.00

Medium Priority Warnings

11

0.00

Low Priority Warnings

2

0.00

**Total Warnings**

**13**

**0.00**

_(\* Defects per Thousand lines of non-commenting source statements)_




Contents
--------

*   [Bad practice Warnings](#Warnings_BAD_PRACTICE)
*   [Malicious code vulnerability Warnings](#Warnings_MALICIOUS_CODE)
*   [Details](#Details)

Summary
=======

Warning Type

Number

[Bad practice Warnings](#Warnings_BAD_PRACTICE)

6

[Malicious code vulnerability Warnings](#Warnings_MALICIOUS_CODE)

7

**Total**

**13**

Warnings
========

Click on a warning row to see full context information.

Bad practice Warnings
---------------------

Code

Warning

Se

ing.atmservice.comparators.ATMModelPriorityComparator implements Comparator but not Serializable

[Bug type SE\_COMPARATOR\_SHOULD\_BE\_SERIALIZABLE (click for details)](#SE_COMPARATOR_SHOULD_BE_SERIALIZABLE)  
In class ing.atmservice.comparators.ATMModelPriorityComparator  
At ATMModelPriorityComparator.java:\[lines 7-11\]

Se

ing.atmservice.comparators.ATMModelRegionComparator implements Comparator but not Serializable

[Bug type SE\_COMPARATOR\_SHOULD\_BE\_SERIALIZABLE (click for details)](#SE_COMPARATOR_SHOULD_BE_SERIALIZABLE)  
In class ing.atmservice.comparators.ATMModelRegionComparator  
At ATMModelRegionComparator.java:\[lines 7-11\]

Se

ing.onlinegame.schemas.Clan$ClansByNumberOfPlayersComparator implements Comparator but not Serializable

[Bug type SE\_COMPARATOR\_SHOULD\_BE\_SERIALIZABLE (click for details)](#SE_COMPARATOR_SHOULD_BE_SERIALIZABLE)  
In class ing.onlinegame.schemas.Clan$ClansByNumberOfPlayersComparator  
At Clan.java:\[lines 42-47\]

Se

ing.onlinegame.schemas.Clan$ClansByPointsComparator implements Comparator but not Serializable

[Bug type SE\_COMPARATOR\_SHOULD\_BE\_SERIALIZABLE (click for details)](#SE_COMPARATOR_SHOULD_BE_SERIALIZABLE)  
In class ing.onlinegame.schemas.Clan$ClansByPointsComparator  
At Clan.java:\[lines 34-38\]

SnVI

ing.onlinegame.schemas.Clan is Serializable; consider declaring a serialVersionUID

[Bug type SE\_NO\_SERIALVERSIONID (click for details)](#SE_NO_SERIALVERSIONID)  
In class ing.onlinegame.schemas.Clan  
At Clan.java:\[lines 15-53\]

SnVI

ing.onlinegame.schemas.Group is Serializable; consider declaring a serialVersionUID

[Bug type SE\_NO\_SERIALVERSIONID (click for details)](#SE_NO_SERIALVERSIONID)  
In class ing.onlinegame.schemas.Group  
At Group.java:\[lines 9-42\]

Malicious code vulnerability Warnings
-------------------------------------

Code

Warning

EI

ing.onlinegame.schemas.Group.getClansList() may expose internal representation by returning Group.clansList

[Bug type EI\_EXPOSE\_REP (click for details)](#EI_EXPOSE_REP)  
In class ing.onlinegame.schemas.Group  
In method ing.onlinegame.schemas.Group.getClansList()  
Field ing.onlinegame.schemas.Group.clansList  
At Group.java:\[line 11\]

EI

ing.onlinegame.schemas.Order.getGroupsOrder() may expose internal representation by returning Order.groupsList

[Bug type EI\_EXPOSE\_REP (click for details)](#EI_EXPOSE_REP)  
In class ing.onlinegame.schemas.Order  
In method ing.onlinegame.schemas.Order.getGroupsOrder()  
Field ing.onlinegame.schemas.Order.groupsList  
At Order.java:\[line 24\]

EI

ing.onlinegame.schemas.Players.getClans() may expose internal representation by returning Players.clans

[Bug type EI\_EXPOSE\_REP (click for details)](#EI_EXPOSE_REP)  
In class ing.onlinegame.schemas.Players  
In method ing.onlinegame.schemas.Players.getClans()  
Field ing.onlinegame.schemas.Players.clans  
At Players.java:\[line 29\]

EI

ing.transactions.schemas.Accounts.getAccountList() may expose internal representation by returning Accounts.accountList

[Bug type EI\_EXPOSE\_REP (click for details)](#EI_EXPOSE_REP)  
In class ing.transactions.schemas.Accounts  
In method ing.transactions.schemas.Accounts.getAccountList()  
Field ing.transactions.schemas.Accounts.accountList  
At Accounts.java:\[line 14\]

EI

ing.transactions.schemas.Transactions.getTransactionsList() may expose internal representation by returning Transactions.transactionsList

[Bug type EI\_EXPOSE\_REP (click for details)](#EI_EXPOSE_REP)  
In class ing.transactions.schemas.Transactions  
In method ing.transactions.schemas.Transactions.getTransactionsList()  
Field ing.transactions.schemas.Transactions.transactionsList  
At Transactions.java:\[line 19\]

EI2

new ing.onlinegame.schemas.Players(int, LinkedList) may expose internal representation by storing an externally mutable object into Players.clans

[Bug type EI\_EXPOSE\_REP2 (click for details)](#EI_EXPOSE_REP2)  
In class ing.onlinegame.schemas.Players  
In method new ing.onlinegame.schemas.Players(int, LinkedList)  
Field ing.onlinegame.schemas.Players.clans  
Local variable named clans  
At Players.java:\[line 14\]

EI2

new ing.transactions.controllers.TransactionController(TransactionService, AccountService) may expose internal representation by storing an externally mutable object into TransactionController.accountService

[Bug type EI\_EXPOSE\_REP2 (click for details)](#EI_EXPOSE_REP2)  
In class ing.transactions.controllers.TransactionController  
In method new ing.transactions.controllers.TransactionController(TransactionService, AccountService)  
Field ing.transactions.controllers.TransactionController.accountService  
Local variable named accountService  
At TransactionController.java:\[line 29\]

Details
=======

EI\_EXPOSE\_REP: May expose internal representation by returning reference to mutable object
--------------------------------------------------------------------------------------------

Returning a reference to a mutable object value stored in one of the object's fields exposes the internal representation of the object.  If instances are accessed by untrusted code, and unchecked changes to the mutable object would compromise security or other important properties, you will need to do something different. Returning a new copy of the object is better approach in many situations.

EI\_EXPOSE\_REP2: May expose internal representation by incorporating reference to mutable object
-------------------------------------------------------------------------------------------------

This code stores a reference to an externally mutable object into the internal representation of the object.  If instances are accessed by untrusted code, and unchecked changes to the mutable object would compromise security or other important properties, you will need to do something different. Storing a copy of the object is better approach in many situations.

SE\_COMPARATOR\_SHOULD\_BE\_SERIALIZABLE: Comparator doesn't implement Serializable
-----------------------------------------------------------------------------------

This class implements the `Comparator` interface. You should consider whether or not it should also implement the `Serializable` interface. If a comparator is used to construct an ordered collection such as a `TreeMap`, then the `TreeMap` will be serializable only if the comparator is also serializable. As most comparators have little or no state, making them serializable is generally easy and good defensive programming.

SE\_NO\_SERIALVERSIONID: Class is Serializable, but doesn't define serialVersionUID
-----------------------------------------------------------------------------------

This class implements the `Serializable` interface, but does not define a `serialVersionUID` field.  A change as simple as adding a reference to a .class object will add synthetic fields to the class, which will unfortunately change the implicit serialVersionUID (e.g., adding a reference to `String.class` will generate a static field `class$java$lang$String`). Also, different source code to bytecode compilers may use different naming conventions for synthetic variables generated for references to class objects or inner classes. To ensure interoperability of Serializable across versions, consider adding an explicit serialVersionUID.