/*
A new Chemistry teacher is very strict and wants the students to do well in class.
To aid this, lectures on each chapter will be repeated periodically through the semester.
In each class, the next chapter is presented, when they reach the end of the book, the lectures start over with chapter 0.
More formally, if there are numChapters in the book, then on the iᵗʰ day, the lecture will be on chapter i % numChapters.
The first day of class is class[0], and the first chapter is chapter 0.

If there are 3 chapters, daily lectures are on chapters class = [0, 1, 2, 0, 1, 2, …]. At class[4],
the lecture will be on chapter 4 % 3 = 1.

One of the students is going to be out of class for a wedding, and the teacher is concerned about missed lectures.
Given the first and last days the student will be out, determine the number of chapters for which the student will miss lectures.

For example, there are numChapters =  4 chapters in the book.
The student is out of class beginning on day b = 3 through ending day e = 5.
The series of lectures are on chapters class = [0, 1, 2, 3, 0, 1, 2, 3, …], starting from day 0.
For class[3] through class[5], lectures are given on chapters 3, 0 and 1. The student will miss lectures on 3 chapters.

Function Description
--------------------
Complete the function missedLectures in the editor below. The function must return an integer.
missedLectures has the following parameters:

numChapters: an integer
firstDay: an integer
lastDay: an integer
 */
/*
🎓 The Problem

A student is absent from:
firstDay to lastDay

We must find:
How many DIFFERENT chapters the student missed?

Not how many days.
Not total lectures.
But how many unique chapters.

Example
-------
numChapters = 4
firstDay = 3
lastDay = 5

From above pattern:

Day 3 → Chapter 3
Day 4 → Chapter 0
Day 5 → Chapter 1

So student missed: 3, 0, 1
Total different chapters missed = 3

🟢 Very Simple Rule

Count how many days the student was absent:
daysMissed = lastDay - firstDay + 1

Now:

If daysMissed ≥ numChapters
→ Student missed ALL chapters

If daysMissed < numChapters
→ Student missed exactly daysMissed chapters

Because chapters are continuous and repeating.
 */
public class missedLectures {
    public static int missedLecturess(int numChapters, int firstDay, int lastDay) {

        int totalDaysMissed = lastDay - firstDay + 1;

        if (totalDaysMissed >= numChapters) {
            return numChapters;
        } else {
            return totalDaysMissed;
        }
    }

    public static void main(String[] args) {
        int numChapters = 4;
        int firstDay = 3;
        int lastDay = 5;

        System.out.println(missedLecturess(numChapters, firstDay, lastDay));
    }
}