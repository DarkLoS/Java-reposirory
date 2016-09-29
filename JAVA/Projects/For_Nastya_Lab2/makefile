# makefile com.company

.SUFFIXES: .class .java

PACK=com.company
TARG=test
JC=javac -g
JM=java -ea -jar
JR=jar -cfe

OBJ=$(PACK)\Main.class \
    $(PACK)\Set.class\
    $(PACK)\ExtraSet.class

.java.class:
	$(JC) $<

run: build
	$(JM) $(TARG).jar

build: 	$(OBJ)
	$(JR) $(TARG).jar $(PACK).test $(OBJ)

clean:
	for %%f in ($(OBJ)) do del %%f
	del $(TARG).jar

$(PACK)\Main.class: $(PACK)\Main.java makefile

$(PACK)\Set.class: $(PACK)\Set.java makefile

$(PACK)\ExtraSet.class: $(PACK)\ExtraSet.java makefile

# eof makefile com.company