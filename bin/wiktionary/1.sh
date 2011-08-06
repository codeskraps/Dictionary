#!/bin/bash
mkdir -p indexes
cat languages | while read language; do
	mkdir -p indexes/$language
	wget -nc "http://en.wiktionary.org/wiki/Index:"$language -O indexes/$language.html
	cd indexes/$language
	cat ../$language.html | sed s/"<"/"\n<"/g | grep "wiki/Index:$language/" | cut -d "\"" -f2 | cut -d "#" -f1 | sort | uniq | while read line; do
		wget -nc "http://en.wiktionary.org"$line
	done
	cd ../../
	mkdir -p wordlists
	cat indexes/$language/* | sed s/"<"/"\n<"/g | grep "a href=\"/wiki" | grep "title=" | grep -v ":" | cut -d ">" -f2 | grep -xv "*" > wordlists/$language.txt
done
