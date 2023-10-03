---
layout: page
title: User Guide
---

FoodNotes is a **desktop app for managing food reviews, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, FoodNotes can get your food review tasks done faster than traditional GUI apps.

* Table of Contents
  {:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start (To be updated)

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `foodnotes.jar` from [here](https://github.com/se-edu/addressbook-level3/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your AddressBook.

1. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar foodnotes.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

    * `list` : Lists all stalls.

    * `add-stall n/Japanese stall l/Deck` : Adds a stall named `Japanese stall` located at `Deck` to the list of stalls.

    * `view-stall s/3` : Shows the 3rd stall shown in the current list.

    * `delete-stall s/3` : Deletes the 3rd stall shown in the current list.


1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

# Features

**View all stalls:** list

**Command format:** list

**Expected output (Success):**
```
Japanese Stall at Deck  ★★★★☆
Cake shop at Engine  ★★★★☆
Noodle stall at Frontier  ★★★★☆
```
**Expected output (Fail):**
```
please enter list only
```
--------------------------------------------------------------------------------------------------------------------
## Stall Features

**1.1 Adding a stall:** add-stall

**Command format:** add-stall n/<STALL_NAME>  l/ <LOCATION>

**Ex.:** add-stall n/Japanese stall l/Deck

**Expected Output (Success):**
```
Yay! Japanese stall at Deck is successfully added to list of stalls.
```
**Expected Output (Fail):**
```
re-enter in the format : add-stall n/<STALL_NAME>  l/ <LOCATION>
```
**1.2 Viewing a stall:** view-stall

**Command format:** view-stall s/<STALL_NUMBER>

**Ex.:** view-stall s/1

**Expected output (Success):**
```
Japanese stall: ★★★★☆
Review: the auntie very chio
Menu
1. Chicken Karage Rice ★★★★☆
2. Chicken Katsu Curry Rice ★★★★★
```
**Expected output (Fail)**:
```
re-enter in the format : view-stall s/<STALL_NUMBER>
```
**1.3 Deleting a stall:** delete-stall

**Command format:** delete-stall s/<STALL_NUMBER>

**Ex.:** delete-stall s/1

**Expected output (Success):**
```
Japanese Stall ★★★★☆ has been deleted.
```

**Expected output (Fail):**

```
re-enter in the format : delete-stall s/<STALL_NUMBER>
```
**1.4 Reviewing a stall:** rate-stall

**Command format:** rate-stall s/STALL_NUMBER r/STALL_RATING d/DESCRIPTION

**Ex.:** rate-stall s/1 r/5 d/the auntie very chio

**Expected output (Success):**
```
Yay! You have added a rating of ★★★★★ for the Japanese Stall
Review: the auntie very chio
```
**Expected output (Fail):**
```
re-enter in the format : rate-stall s/STALL_NUMBER r/STALL_RATING d/DESCRIPTION
```
**Acceptable values:**
- s/: Positive Integer less than or equal to the size of list
- r/: Integer from 0 to 5
- d/: String
--------------------------------------------------------------------------------------------------------------------
## Item Features

**2.1 Adding an item to a stall:** add-item

**Command format:** add-item s/STALL_NUMBER i/ITEM

**Ex.:** add-item s/1 i/Chicken Rice

**Expected output (Success):**
```
Yay! Chicken Rice is successfully added as a menu item for Japanese Stall at Deck
```
**Expected output (Fail):**
```
re-enter in the format : add-item s/STALL_NUMBER i/ITEM
```
**Acceptable values:**

- s/: Positive Integer less than or equal to the size of list,

- i/: String

**2.2 Viewing an item from a stall:** view-item

**Command format:** view-item s/STALL_NUMBER i/ITEM_NUMBER

**Ex.:** view-item s/1 i/1

**Expected output (Success):**
```
Chicken Karage Rice ★★★☆☆
Review: Great fried chicken that’s crunchy and juicy, but there’s only 3 pieces and everything is in dire need of sauce, meaning it’s not quite bang for buck and you might be hungry again in a few hours.
```

**Expected output (Fail):**

```
re-enter in the format : view-item s/STALL_NUMBER i/ITEM_NUMBER
```
**Acceptable values:**
- s/: Positive Integer less than or equal to the size of list,
- i/: Positive Integer less than or equal to the size of list

**2.3 Deleting an item from a stall:** delete-item

**Command format:** delete-item s/STALL_NUMBER i/ITEM_NUMBER

**Ex.:** delete-item s/1 i/1

**Expected output (Success):**
```
Chicken Karaage Rice ★★★★☆ has been deleted from Japanese Stall
```
**Expected output (Fail):**
```
re-enter in the format : delete-item s/STALL_NUMBER i/ITEM_NUMBER
```
**Acceptable values:**
- s/: Positive Integer less than or equal to the size of list
- i/: Positive Integer less than or equal to the size of list

**2.4 Reviewing an item:** rate-item

**Command format:** rate-item s/STALL_NUMBER i/ITEM_NUMBER r/ITEM_RATING d/DESCRIPTION

**Ex.:** rate-item s/1 i/1 r/5 d/the auntie very chio

**Expected output (Success):**
```
Yay! You have added a rating of ★★★★★ for the Chicken Rice at the Japanese Stall
Review: the auntie very chio
```
**Expected output (Fail):**
```
re-enter in the format: rate-item s/STALL_NUMBER i/ITEM_NUMBER r/ITEM_RATING d/DESCRIPTION
```
**Acceptable values:**
- s/: Positive Integer less than or equal to the size of list
- i/: Positive Integer less than or equal to the size of list
- r/: Integer from 0 to 5
- d/: String
--------------------------------------------------------------------------------------------------------------------
