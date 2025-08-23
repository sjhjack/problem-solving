# [Silver III] Another Word Sorting - 9794 

[문제 링크](https://www.acmicpc.net/problem/9794) 

### 성능 요약

메모리: 14420 KB, 시간: 108 ms

### 분류

정렬, 문자열

### 제출 일자

2025년 8월 23일 11:11:00

### 문제 설명

<p>A new scoring system for a word is invented and described as follows. Each letter has a value according to its alphabetic position e.g. a = 1, b=2, c=3, ..., z = 26. The score of a word is the sum of values of its letters plus the bonus. When a word has double letters (2 consecutive same letters), it will obtain the bonus of 2 times the letter value. Take a look at these examples:</p>

<pre>apple = (1+16+16+12+5) + bonus 2x16 = 82
banana = (2+1+14+1+14+1) = 33 (no bonus)
orange = 15+18+1+14+7+5 = 60 (no bonus)
acted = (1+3+20+5+4) = 33 (no bonus)
commit = 3+15+13+13+9+20 + bonus 13x2 = 99</pre>

<p>A letter can be used to calculate the bonus only once.</p>

<p>Given a list of words, your task is to rearrange them in descending order of their scores. In case of equal score, sort the words lexicographically.</p>

### 입력 

 <p>The input contains a sequence of words each in a separate line. Each word contains only lower case letters (a...z) and has no more than 20 letters. The input can contain up to one 1,000 lines.</p>

### 출력 

 <p>The output includes a sequence of the input words rearranged by this method. Each line contains only one word. If there are duplicate words, conserve all of them. There are neither blanks nor blank lines in the output.</p>

