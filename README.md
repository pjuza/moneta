# moneta
Moneta example for interview

## Run standalone
java $JAVA_OPTS -Dserver.port=8080 -Ddebug  -jar target/moneta-example-exec.war

## REST services

### Transforms input text [POST /api/text/transform]
Transforms input text/request according to the following rules:
- the text will be reverted: abc -> cba
- two and mores spaces join to only one space
- characters a,e,i,o,u (also diacritics variants such as í, Á, ů, Ě) will be replaced by uppercase characters

+ Request (text/plain)
    
+ Response 200 (text/plain) 