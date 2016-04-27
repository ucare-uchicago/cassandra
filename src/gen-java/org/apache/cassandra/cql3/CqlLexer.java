// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g 2016-04-26 17:48:08

    package org.apache.cassandra.cql3;

    import org.apache.cassandra.exceptions.SyntaxException;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CqlLexer extends Lexer {
    public static final int LETTER=108;
    public static final int K_INT=74;
    public static final int K_CREATE=31;
    public static final int K_CLUSTERING=39;
    public static final int K_WRITETIME=16;
    public static final int EOF=-1;
    public static final int K_PRIMARY=35;
    public static final int K_VALUES=23;
    public static final int K_USE=4;
    public static final int STRING_LITERAL=50;
    public static final int K_GRANT=48;
    public static final int K_ON=42;
    public static final int K_USING=8;
    public static final int K_ADD=45;
    public static final int K_ASC=19;
    public static final int K_KEY=36;
    public static final int K_TRUNCATE=47;
    public static final int COMMENT=111;
    public static final int K_FULL_ACCESS=57;
    public static final int K_ORDER=12;
    public static final int D=94;
    public static final int E=82;
    public static final int F=86;
    public static final int G=100;
    public static final int K_TYPE=44;
    public static final int K_KEYSPACE=32;
    public static final int K_COUNT=6;
    public static final int A=92;
    public static final int B=102;
    public static final int C=84;
    public static final int L=83;
    public static final int M=89;
    public static final int N=93;
    public static final int O=88;
    public static final int H=91;
    public static final int I=97;
    public static final int K_UPDATE=25;
    public static final int J=105;
    public static final int K=95;
    public static final int U=98;
    public static final int T=85;
    public static final int W=90;
    public static final int K_TEXT=75;
    public static final int V=104;
    public static final int Q=101;
    public static final int P=99;
    public static final int K_COMPACT=37;
    public static final int S=81;
    public static final int R=87;
    public static final int K_TTL=17;
    public static final int Y=96;
    public static final int X=103;
    public static final int Z=106;
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int K_INDEX=40;
    public static final int T__128=128;
    public static final int K_INSERT=21;
    public static final int T__127=127;
    public static final int WS=110;
    public static final int T__129=129;
    public static final int K_APPLY=30;
    public static final int K_INET=73;
    public static final int K_STORAGE=38;
    public static final int K_TIMESTAMP=24;
    public static final int K_AND=18;
    public static final int K_DESC=20;
    public static final int T__130=130;
    public static final int QMARK=62;
    public static final int K_TOKEN=63;
    public static final int K_LEVEL=10;
    public static final int K_UUID=76;
    public static final int K_BATCH=29;
    public static final int K_GRANTS=54;
    public static final int K_ASCII=65;
    public static final int UUID=60;
    public static final int T__118=118;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int K_LIST=53;
    public static final int T__117=117;
    public static final int K_DELETE=27;
    public static final int K_FOR=55;
    public static final int T__114=114;
    public static final int T__115=115;
    public static final int T__124=124;
    public static final int T__123=123;
    public static final int K_TO=49;
    public static final int T__122=122;
    public static final int T__121=121;
    public static final int K_BY=13;
    public static final int FLOAT=61;
    public static final int T__120=120;
    public static final int K_FLOAT=72;
    public static final int K_VARINT=78;
    public static final int K_DOUBLE=71;
    public static final int K_SELECT=5;
    public static final int K_LIMIT=14;
    public static final int K_BOOLEAN=68;
    public static final int K_ALTER=43;
    public static final int K_SET=26;
    public static final int K_WHERE=11;
    public static final int QUOTED_NAME=59;
    public static final int K_DESCRIBE=56;
    public static final int MULTILINE_COMMENT=112;
    public static final int K_BLOB=67;
    public static final int K_INTO=22;
    public static final int HEX=109;
    public static final int K_REVOKE=52;
    public static final int K_VARCHAR=77;
    public static final int IDENT=41;
    public static final int T__113=113;
    public static final int DIGIT=107;
    public static final int K_BEGIN=28;
    public static final int INTEGER=15;
    public static final int K_COUNTER=69;
    public static final int K_DECIMAL=70;
    public static final int K_CONSISTENCY=9;
    public static final int K_WITH=33;
    public static final int K_IN=64;
    public static final int K_NO_ACCESS=58;
    public static final int K_MAP=80;
    public static final int K_FROM=7;
    public static final int K_COLUMNFAMILY=34;
    public static final int K_OPTION=51;
    public static final int K_DROP=46;
    public static final int K_BIGINT=66;
    public static final int K_TIMEUUID=79;

        List<Token> tokens = new ArrayList<Token>();

        public void emit(Token token)
        {
            state.token = token;
            tokens.add(token);
        }

        public Token nextToken()
        {
            super.nextToken();
            if (tokens.size() == 0)
                return Token.EOF_TOKEN;
            return tokens.remove(0);
        }

        private List<String> recognitionErrors = new ArrayList<String>();

        public void displayRecognitionError(String[] tokenNames, RecognitionException e)
        {
            String hdr = getErrorHeader(e);
            String msg = getErrorMessage(e, tokenNames);
            recognitionErrors.add(hdr + " " + msg);
        }

        public List<String> getRecognitionErrors()
        {
            return recognitionErrors;
        }

        public void throwLastRecognitionError() throws SyntaxException
        {
            if (recognitionErrors.size() > 0)
                throw new SyntaxException(recognitionErrors.get((recognitionErrors.size()-1)));
        }


    // delegates
    // delegators

    public CqlLexer() {;} 
    public CqlLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CqlLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g"; }

    // $ANTLR start "T__113"
    public final void mT__113() throws RecognitionException {
        try {
            int _type = T__113;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:50:8: ( ';' )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:50:10: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__113"

    // $ANTLR start "T__114"
    public final void mT__114() throws RecognitionException {
        try {
            int _type = T__114;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:51:8: ( '(' )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:51:10: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__114"

    // $ANTLR start "T__115"
    public final void mT__115() throws RecognitionException {
        try {
            int _type = T__115;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:52:8: ( ')' )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:52:10: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__115"

    // $ANTLR start "T__116"
    public final void mT__116() throws RecognitionException {
        try {
            int _type = T__116;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:53:8: ( ',' )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:53:10: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__116"

    // $ANTLR start "T__117"
    public final void mT__117() throws RecognitionException {
        try {
            int _type = T__117;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:54:8: ( '\\*' )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:54:10: '\\*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__117"

    // $ANTLR start "T__118"
    public final void mT__118() throws RecognitionException {
        try {
            int _type = T__118;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:55:8: ( '[' )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:55:10: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__118"

    // $ANTLR start "T__119"
    public final void mT__119() throws RecognitionException {
        try {
            int _type = T__119;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:56:8: ( ']' )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:56:10: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__119"

    // $ANTLR start "T__120"
    public final void mT__120() throws RecognitionException {
        try {
            int _type = T__120;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:57:8: ( '.' )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:57:10: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__120"

    // $ANTLR start "T__121"
    public final void mT__121() throws RecognitionException {
        try {
            int _type = T__121;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:58:8: ( '{' )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:58:10: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__121"

    // $ANTLR start "T__122"
    public final void mT__122() throws RecognitionException {
        try {
            int _type = T__122;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:59:8: ( '}' )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:59:10: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__122"

    // $ANTLR start "T__123"
    public final void mT__123() throws RecognitionException {
        try {
            int _type = T__123;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:60:8: ( ':' )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:60:10: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__123"

    // $ANTLR start "T__124"
    public final void mT__124() throws RecognitionException {
        try {
            int _type = T__124;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:61:8: ( '=' )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:61:10: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__124"

    // $ANTLR start "T__125"
    public final void mT__125() throws RecognitionException {
        try {
            int _type = T__125;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:62:8: ( '+' )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:62:10: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__125"

    // $ANTLR start "T__126"
    public final void mT__126() throws RecognitionException {
        try {
            int _type = T__126;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:63:8: ( '-' )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:63:10: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__126"

    // $ANTLR start "T__127"
    public final void mT__127() throws RecognitionException {
        try {
            int _type = T__127;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:64:8: ( '<' )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:64:10: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__127"

    // $ANTLR start "T__128"
    public final void mT__128() throws RecognitionException {
        try {
            int _type = T__128;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:65:8: ( '<=' )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:65:10: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__128"

    // $ANTLR start "T__129"
    public final void mT__129() throws RecognitionException {
        try {
            int _type = T__129;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:66:8: ( '>=' )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:66:10: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__129"

    // $ANTLR start "T__130"
    public final void mT__130() throws RecognitionException {
        try {
            int _type = T__130;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:67:8: ( '>' )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:67:10: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__130"

    // $ANTLR start "K_SELECT"
    public final void mK_SELECT() throws RecognitionException {
        try {
            int _type = K_SELECT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:745:9: ( S E L E C T )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:745:16: S E L E C T
            {
            mS(); 
            mE(); 
            mL(); 
            mE(); 
            mC(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_SELECT"

    // $ANTLR start "K_FROM"
    public final void mK_FROM() throws RecognitionException {
        try {
            int _type = K_FROM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:746:7: ( F R O M )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:746:16: F R O M
            {
            mF(); 
            mR(); 
            mO(); 
            mM(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_FROM"

    // $ANTLR start "K_WHERE"
    public final void mK_WHERE() throws RecognitionException {
        try {
            int _type = K_WHERE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:747:8: ( W H E R E )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:747:16: W H E R E
            {
            mW(); 
            mH(); 
            mE(); 
            mR(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_WHERE"

    // $ANTLR start "K_AND"
    public final void mK_AND() throws RecognitionException {
        try {
            int _type = K_AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:748:6: ( A N D )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:748:16: A N D
            {
            mA(); 
            mN(); 
            mD(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_AND"

    // $ANTLR start "K_KEY"
    public final void mK_KEY() throws RecognitionException {
        try {
            int _type = K_KEY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:749:6: ( K E Y )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:749:16: K E Y
            {
            mK(); 
            mE(); 
            mY(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_KEY"

    // $ANTLR start "K_INSERT"
    public final void mK_INSERT() throws RecognitionException {
        try {
            int _type = K_INSERT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:750:9: ( I N S E R T )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:750:16: I N S E R T
            {
            mI(); 
            mN(); 
            mS(); 
            mE(); 
            mR(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_INSERT"

    // $ANTLR start "K_UPDATE"
    public final void mK_UPDATE() throws RecognitionException {
        try {
            int _type = K_UPDATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:751:9: ( U P D A T E )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:751:16: U P D A T E
            {
            mU(); 
            mP(); 
            mD(); 
            mA(); 
            mT(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_UPDATE"

    // $ANTLR start "K_WITH"
    public final void mK_WITH() throws RecognitionException {
        try {
            int _type = K_WITH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:752:7: ( W I T H )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:752:16: W I T H
            {
            mW(); 
            mI(); 
            mT(); 
            mH(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_WITH"

    // $ANTLR start "K_LIMIT"
    public final void mK_LIMIT() throws RecognitionException {
        try {
            int _type = K_LIMIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:753:8: ( L I M I T )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:753:16: L I M I T
            {
            mL(); 
            mI(); 
            mM(); 
            mI(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_LIMIT"

    // $ANTLR start "K_USING"
    public final void mK_USING() throws RecognitionException {
        try {
            int _type = K_USING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:754:8: ( U S I N G )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:754:16: U S I N G
            {
            mU(); 
            mS(); 
            mI(); 
            mN(); 
            mG(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_USING"

    // $ANTLR start "K_CONSISTENCY"
    public final void mK_CONSISTENCY() throws RecognitionException {
        try {
            int _type = K_CONSISTENCY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:755:14: ( C O N S I S T E N C Y )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:755:16: C O N S I S T E N C Y
            {
            mC(); 
            mO(); 
            mN(); 
            mS(); 
            mI(); 
            mS(); 
            mT(); 
            mE(); 
            mN(); 
            mC(); 
            mY(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_CONSISTENCY"

    // $ANTLR start "K_LEVEL"
    public final void mK_LEVEL() throws RecognitionException {
        try {
            int _type = K_LEVEL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:756:8: ( ( O N E | Q U O R U M | A L L | A N Y | L O C A L '_' Q U O R U M | E A C H '_' Q U O R U M | T W O | T H R E E ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:756:16: ( O N E | Q U O R U M | A L L | A N Y | L O C A L '_' Q U O R U M | E A C H '_' Q U O R U M | T W O | T H R E E )
            {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:756:16: ( O N E | Q U O R U M | A L L | A N Y | L O C A L '_' Q U O R U M | E A C H '_' Q U O R U M | T W O | T H R E E )
            int alt1=8;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:756:18: O N E
                    {
                    mO(); 
                    mN(); 
                    mE(); 

                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:757:18: Q U O R U M
                    {
                    mQ(); 
                    mU(); 
                    mO(); 
                    mR(); 
                    mU(); 
                    mM(); 

                    }
                    break;
                case 3 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:758:18: A L L
                    {
                    mA(); 
                    mL(); 
                    mL(); 

                    }
                    break;
                case 4 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:759:18: A N Y
                    {
                    mA(); 
                    mN(); 
                    mY(); 

                    }
                    break;
                case 5 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:760:18: L O C A L '_' Q U O R U M
                    {
                    mL(); 
                    mO(); 
                    mC(); 
                    mA(); 
                    mL(); 
                    match('_'); 
                    mQ(); 
                    mU(); 
                    mO(); 
                    mR(); 
                    mU(); 
                    mM(); 

                    }
                    break;
                case 6 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:761:18: E A C H '_' Q U O R U M
                    {
                    mE(); 
                    mA(); 
                    mC(); 
                    mH(); 
                    match('_'); 
                    mQ(); 
                    mU(); 
                    mO(); 
                    mR(); 
                    mU(); 
                    mM(); 

                    }
                    break;
                case 7 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:762:18: T W O
                    {
                    mT(); 
                    mW(); 
                    mO(); 

                    }
                    break;
                case 8 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:763:18: T H R E E
                    {
                    mT(); 
                    mH(); 
                    mR(); 
                    mE(); 
                    mE(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_LEVEL"

    // $ANTLR start "K_USE"
    public final void mK_USE() throws RecognitionException {
        try {
            int _type = K_USE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:766:6: ( U S E )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:766:16: U S E
            {
            mU(); 
            mS(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_USE"

    // $ANTLR start "K_COUNT"
    public final void mK_COUNT() throws RecognitionException {
        try {
            int _type = K_COUNT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:767:8: ( C O U N T )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:767:16: C O U N T
            {
            mC(); 
            mO(); 
            mU(); 
            mN(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_COUNT"

    // $ANTLR start "K_SET"
    public final void mK_SET() throws RecognitionException {
        try {
            int _type = K_SET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:768:6: ( S E T )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:768:16: S E T
            {
            mS(); 
            mE(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_SET"

    // $ANTLR start "K_BEGIN"
    public final void mK_BEGIN() throws RecognitionException {
        try {
            int _type = K_BEGIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:769:8: ( B E G I N )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:769:16: B E G I N
            {
            mB(); 
            mE(); 
            mG(); 
            mI(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_BEGIN"

    // $ANTLR start "K_APPLY"
    public final void mK_APPLY() throws RecognitionException {
        try {
            int _type = K_APPLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:770:8: ( A P P L Y )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:770:16: A P P L Y
            {
            mA(); 
            mP(); 
            mP(); 
            mL(); 
            mY(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_APPLY"

    // $ANTLR start "K_BATCH"
    public final void mK_BATCH() throws RecognitionException {
        try {
            int _type = K_BATCH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:771:8: ( B A T C H )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:771:16: B A T C H
            {
            mB(); 
            mA(); 
            mT(); 
            mC(); 
            mH(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_BATCH"

    // $ANTLR start "K_TRUNCATE"
    public final void mK_TRUNCATE() throws RecognitionException {
        try {
            int _type = K_TRUNCATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:772:11: ( T R U N C A T E )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:772:16: T R U N C A T E
            {
            mT(); 
            mR(); 
            mU(); 
            mN(); 
            mC(); 
            mA(); 
            mT(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_TRUNCATE"

    // $ANTLR start "K_DELETE"
    public final void mK_DELETE() throws RecognitionException {
        try {
            int _type = K_DELETE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:773:9: ( D E L E T E )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:773:16: D E L E T E
            {
            mD(); 
            mE(); 
            mL(); 
            mE(); 
            mT(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_DELETE"

    // $ANTLR start "K_IN"
    public final void mK_IN() throws RecognitionException {
        try {
            int _type = K_IN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:774:5: ( I N )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:774:16: I N
            {
            mI(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_IN"

    // $ANTLR start "K_CREATE"
    public final void mK_CREATE() throws RecognitionException {
        try {
            int _type = K_CREATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:775:9: ( C R E A T E )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:775:16: C R E A T E
            {
            mC(); 
            mR(); 
            mE(); 
            mA(); 
            mT(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_CREATE"

    // $ANTLR start "K_KEYSPACE"
    public final void mK_KEYSPACE() throws RecognitionException {
        try {
            int _type = K_KEYSPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:776:11: ( ( K E Y S P A C E | S C H E M A ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:776:16: ( K E Y S P A C E | S C H E M A )
            {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:776:16: ( K E Y S P A C E | S C H E M A )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='K'||LA2_0=='k') ) {
                alt2=1;
            }
            else if ( (LA2_0=='S'||LA2_0=='s') ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:776:18: K E Y S P A C E
                    {
                    mK(); 
                    mE(); 
                    mY(); 
                    mS(); 
                    mP(); 
                    mA(); 
                    mC(); 
                    mE(); 

                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:777:20: S C H E M A
                    {
                    mS(); 
                    mC(); 
                    mH(); 
                    mE(); 
                    mM(); 
                    mA(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_KEYSPACE"

    // $ANTLR start "K_COLUMNFAMILY"
    public final void mK_COLUMNFAMILY() throws RecognitionException {
        try {
            int _type = K_COLUMNFAMILY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:778:15: ( ( C O L U M N F A M I L Y | T A B L E ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:778:16: ( C O L U M N F A M I L Y | T A B L E )
            {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:778:16: ( C O L U M N F A M I L Y | T A B L E )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='C'||LA3_0=='c') ) {
                alt3=1;
            }
            else if ( (LA3_0=='T'||LA3_0=='t') ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:778:18: C O L U M N F A M I L Y
                    {
                    mC(); 
                    mO(); 
                    mL(); 
                    mU(); 
                    mM(); 
                    mN(); 
                    mF(); 
                    mA(); 
                    mM(); 
                    mI(); 
                    mL(); 
                    mY(); 

                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:779:20: T A B L E
                    {
                    mT(); 
                    mA(); 
                    mB(); 
                    mL(); 
                    mE(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_COLUMNFAMILY"

    // $ANTLR start "K_INDEX"
    public final void mK_INDEX() throws RecognitionException {
        try {
            int _type = K_INDEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:780:8: ( I N D E X )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:780:16: I N D E X
            {
            mI(); 
            mN(); 
            mD(); 
            mE(); 
            mX(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_INDEX"

    // $ANTLR start "K_ON"
    public final void mK_ON() throws RecognitionException {
        try {
            int _type = K_ON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:781:5: ( O N )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:781:16: O N
            {
            mO(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_ON"

    // $ANTLR start "K_TO"
    public final void mK_TO() throws RecognitionException {
        try {
            int _type = K_TO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:782:5: ( T O )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:782:16: T O
            {
            mT(); 
            mO(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_TO"

    // $ANTLR start "K_DROP"
    public final void mK_DROP() throws RecognitionException {
        try {
            int _type = K_DROP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:783:7: ( D R O P )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:783:16: D R O P
            {
            mD(); 
            mR(); 
            mO(); 
            mP(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_DROP"

    // $ANTLR start "K_PRIMARY"
    public final void mK_PRIMARY() throws RecognitionException {
        try {
            int _type = K_PRIMARY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:784:10: ( P R I M A R Y )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:784:16: P R I M A R Y
            {
            mP(); 
            mR(); 
            mI(); 
            mM(); 
            mA(); 
            mR(); 
            mY(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_PRIMARY"

    // $ANTLR start "K_INTO"
    public final void mK_INTO() throws RecognitionException {
        try {
            int _type = K_INTO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:785:7: ( I N T O )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:785:16: I N T O
            {
            mI(); 
            mN(); 
            mT(); 
            mO(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_INTO"

    // $ANTLR start "K_VALUES"
    public final void mK_VALUES() throws RecognitionException {
        try {
            int _type = K_VALUES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:786:9: ( V A L U E S )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:786:16: V A L U E S
            {
            mV(); 
            mA(); 
            mL(); 
            mU(); 
            mE(); 
            mS(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_VALUES"

    // $ANTLR start "K_TIMESTAMP"
    public final void mK_TIMESTAMP() throws RecognitionException {
        try {
            int _type = K_TIMESTAMP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:787:12: ( T I M E S T A M P )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:787:16: T I M E S T A M P
            {
            mT(); 
            mI(); 
            mM(); 
            mE(); 
            mS(); 
            mT(); 
            mA(); 
            mM(); 
            mP(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_TIMESTAMP"

    // $ANTLR start "K_TTL"
    public final void mK_TTL() throws RecognitionException {
        try {
            int _type = K_TTL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:788:6: ( T T L )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:788:16: T T L
            {
            mT(); 
            mT(); 
            mL(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_TTL"

    // $ANTLR start "K_ALTER"
    public final void mK_ALTER() throws RecognitionException {
        try {
            int _type = K_ALTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:789:8: ( A L T E R )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:789:16: A L T E R
            {
            mA(); 
            mL(); 
            mT(); 
            mE(); 
            mR(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_ALTER"

    // $ANTLR start "K_ADD"
    public final void mK_ADD() throws RecognitionException {
        try {
            int _type = K_ADD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:790:6: ( A D D )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:790:16: A D D
            {
            mA(); 
            mD(); 
            mD(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_ADD"

    // $ANTLR start "K_TYPE"
    public final void mK_TYPE() throws RecognitionException {
        try {
            int _type = K_TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:791:7: ( T Y P E )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:791:16: T Y P E
            {
            mT(); 
            mY(); 
            mP(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_TYPE"

    // $ANTLR start "K_COMPACT"
    public final void mK_COMPACT() throws RecognitionException {
        try {
            int _type = K_COMPACT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:792:10: ( C O M P A C T )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:792:16: C O M P A C T
            {
            mC(); 
            mO(); 
            mM(); 
            mP(); 
            mA(); 
            mC(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_COMPACT"

    // $ANTLR start "K_STORAGE"
    public final void mK_STORAGE() throws RecognitionException {
        try {
            int _type = K_STORAGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:793:10: ( S T O R A G E )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:793:16: S T O R A G E
            {
            mS(); 
            mT(); 
            mO(); 
            mR(); 
            mA(); 
            mG(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_STORAGE"

    // $ANTLR start "K_ORDER"
    public final void mK_ORDER() throws RecognitionException {
        try {
            int _type = K_ORDER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:794:8: ( O R D E R )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:794:16: O R D E R
            {
            mO(); 
            mR(); 
            mD(); 
            mE(); 
            mR(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_ORDER"

    // $ANTLR start "K_BY"
    public final void mK_BY() throws RecognitionException {
        try {
            int _type = K_BY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:795:5: ( B Y )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:795:16: B Y
            {
            mB(); 
            mY(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_BY"

    // $ANTLR start "K_ASC"
    public final void mK_ASC() throws RecognitionException {
        try {
            int _type = K_ASC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:796:6: ( A S C )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:796:16: A S C
            {
            mA(); 
            mS(); 
            mC(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_ASC"

    // $ANTLR start "K_DESC"
    public final void mK_DESC() throws RecognitionException {
        try {
            int _type = K_DESC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:797:7: ( D E S C )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:797:16: D E S C
            {
            mD(); 
            mE(); 
            mS(); 
            mC(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_DESC"

    // $ANTLR start "K_GRANT"
    public final void mK_GRANT() throws RecognitionException {
        try {
            int _type = K_GRANT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:798:8: ( G R A N T )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:798:16: G R A N T
            {
            mG(); 
            mR(); 
            mA(); 
            mN(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_GRANT"

    // $ANTLR start "K_GRANTS"
    public final void mK_GRANTS() throws RecognitionException {
        try {
            int _type = K_GRANTS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:799:9: ( G R A N T S )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:799:16: G R A N T S
            {
            mG(); 
            mR(); 
            mA(); 
            mN(); 
            mT(); 
            mS(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_GRANTS"

    // $ANTLR start "K_REVOKE"
    public final void mK_REVOKE() throws RecognitionException {
        try {
            int _type = K_REVOKE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:800:9: ( R E V O K E )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:800:16: R E V O K E
            {
            mR(); 
            mE(); 
            mV(); 
            mO(); 
            mK(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_REVOKE"

    // $ANTLR start "K_OPTION"
    public final void mK_OPTION() throws RecognitionException {
        try {
            int _type = K_OPTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:801:9: ( O P T I O N )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:801:16: O P T I O N
            {
            mO(); 
            mP(); 
            mT(); 
            mI(); 
            mO(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_OPTION"

    // $ANTLR start "K_DESCRIBE"
    public final void mK_DESCRIBE() throws RecognitionException {
        try {
            int _type = K_DESCRIBE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:802:11: ( D E S C R I B E )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:802:16: D E S C R I B E
            {
            mD(); 
            mE(); 
            mS(); 
            mC(); 
            mR(); 
            mI(); 
            mB(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_DESCRIBE"

    // $ANTLR start "K_FOR"
    public final void mK_FOR() throws RecognitionException {
        try {
            int _type = K_FOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:803:6: ( F O R )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:803:16: F O R
            {
            mF(); 
            mO(); 
            mR(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_FOR"

    // $ANTLR start "K_FULL_ACCESS"
    public final void mK_FULL_ACCESS() throws RecognitionException {
        try {
            int _type = K_FULL_ACCESS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:804:14: ( F U L L '_' A C C E S S )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:804:16: F U L L '_' A C C E S S
            {
            mF(); 
            mU(); 
            mL(); 
            mL(); 
            match('_'); 
            mA(); 
            mC(); 
            mC(); 
            mE(); 
            mS(); 
            mS(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_FULL_ACCESS"

    // $ANTLR start "K_NO_ACCESS"
    public final void mK_NO_ACCESS() throws RecognitionException {
        try {
            int _type = K_NO_ACCESS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:805:12: ( N O '_' A C C E S S )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:805:16: N O '_' A C C E S S
            {
            mN(); 
            mO(); 
            match('_'); 
            mA(); 
            mC(); 
            mC(); 
            mE(); 
            mS(); 
            mS(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_NO_ACCESS"

    // $ANTLR start "K_CLUSTERING"
    public final void mK_CLUSTERING() throws RecognitionException {
        try {
            int _type = K_CLUSTERING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:808:13: ( C L U S T E R I N G )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:808:16: C L U S T E R I N G
            {
            mC(); 
            mL(); 
            mU(); 
            mS(); 
            mT(); 
            mE(); 
            mR(); 
            mI(); 
            mN(); 
            mG(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_CLUSTERING"

    // $ANTLR start "K_ASCII"
    public final void mK_ASCII() throws RecognitionException {
        try {
            int _type = K_ASCII;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:809:8: ( A S C I I )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:809:16: A S C I I
            {
            mA(); 
            mS(); 
            mC(); 
            mI(); 
            mI(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_ASCII"

    // $ANTLR start "K_BIGINT"
    public final void mK_BIGINT() throws RecognitionException {
        try {
            int _type = K_BIGINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:810:9: ( B I G I N T )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:810:16: B I G I N T
            {
            mB(); 
            mI(); 
            mG(); 
            mI(); 
            mN(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_BIGINT"

    // $ANTLR start "K_BLOB"
    public final void mK_BLOB() throws RecognitionException {
        try {
            int _type = K_BLOB;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:811:7: ( B L O B )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:811:16: B L O B
            {
            mB(); 
            mL(); 
            mO(); 
            mB(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_BLOB"

    // $ANTLR start "K_BOOLEAN"
    public final void mK_BOOLEAN() throws RecognitionException {
        try {
            int _type = K_BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:812:10: ( B O O L E A N )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:812:16: B O O L E A N
            {
            mB(); 
            mO(); 
            mO(); 
            mL(); 
            mE(); 
            mA(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_BOOLEAN"

    // $ANTLR start "K_COUNTER"
    public final void mK_COUNTER() throws RecognitionException {
        try {
            int _type = K_COUNTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:813:10: ( C O U N T E R )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:813:16: C O U N T E R
            {
            mC(); 
            mO(); 
            mU(); 
            mN(); 
            mT(); 
            mE(); 
            mR(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_COUNTER"

    // $ANTLR start "K_DECIMAL"
    public final void mK_DECIMAL() throws RecognitionException {
        try {
            int _type = K_DECIMAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:814:10: ( D E C I M A L )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:814:16: D E C I M A L
            {
            mD(); 
            mE(); 
            mC(); 
            mI(); 
            mM(); 
            mA(); 
            mL(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_DECIMAL"

    // $ANTLR start "K_DOUBLE"
    public final void mK_DOUBLE() throws RecognitionException {
        try {
            int _type = K_DOUBLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:815:9: ( D O U B L E )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:815:16: D O U B L E
            {
            mD(); 
            mO(); 
            mU(); 
            mB(); 
            mL(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_DOUBLE"

    // $ANTLR start "K_FLOAT"
    public final void mK_FLOAT() throws RecognitionException {
        try {
            int _type = K_FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:816:8: ( F L O A T )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:816:16: F L O A T
            {
            mF(); 
            mL(); 
            mO(); 
            mA(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_FLOAT"

    // $ANTLR start "K_INET"
    public final void mK_INET() throws RecognitionException {
        try {
            int _type = K_INET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:817:7: ( I N E T )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:817:16: I N E T
            {
            mI(); 
            mN(); 
            mE(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_INET"

    // $ANTLR start "K_INT"
    public final void mK_INT() throws RecognitionException {
        try {
            int _type = K_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:818:6: ( I N T )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:818:16: I N T
            {
            mI(); 
            mN(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_INT"

    // $ANTLR start "K_TEXT"
    public final void mK_TEXT() throws RecognitionException {
        try {
            int _type = K_TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:819:7: ( T E X T )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:819:16: T E X T
            {
            mT(); 
            mE(); 
            mX(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_TEXT"

    // $ANTLR start "K_UUID"
    public final void mK_UUID() throws RecognitionException {
        try {
            int _type = K_UUID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:820:7: ( U U I D )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:820:16: U U I D
            {
            mU(); 
            mU(); 
            mI(); 
            mD(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_UUID"

    // $ANTLR start "K_VARCHAR"
    public final void mK_VARCHAR() throws RecognitionException {
        try {
            int _type = K_VARCHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:821:10: ( V A R C H A R )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:821:16: V A R C H A R
            {
            mV(); 
            mA(); 
            mR(); 
            mC(); 
            mH(); 
            mA(); 
            mR(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_VARCHAR"

    // $ANTLR start "K_VARINT"
    public final void mK_VARINT() throws RecognitionException {
        try {
            int _type = K_VARINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:822:9: ( V A R I N T )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:822:16: V A R I N T
            {
            mV(); 
            mA(); 
            mR(); 
            mI(); 
            mN(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_VARINT"

    // $ANTLR start "K_TIMEUUID"
    public final void mK_TIMEUUID() throws RecognitionException {
        try {
            int _type = K_TIMEUUID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:823:11: ( T I M E U U I D )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:823:16: T I M E U U I D
            {
            mT(); 
            mI(); 
            mM(); 
            mE(); 
            mU(); 
            mU(); 
            mI(); 
            mD(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_TIMEUUID"

    // $ANTLR start "K_TOKEN"
    public final void mK_TOKEN() throws RecognitionException {
        try {
            int _type = K_TOKEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:824:8: ( T O K E N )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:824:16: T O K E N
            {
            mT(); 
            mO(); 
            mK(); 
            mE(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_TOKEN"

    // $ANTLR start "K_WRITETIME"
    public final void mK_WRITETIME() throws RecognitionException {
        try {
            int _type = K_WRITETIME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:825:12: ( W R I T E T I M E )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:825:16: W R I T E T I M E
            {
            mW(); 
            mR(); 
            mI(); 
            mT(); 
            mE(); 
            mT(); 
            mI(); 
            mM(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_WRITETIME"

    // $ANTLR start "K_MAP"
    public final void mK_MAP() throws RecognitionException {
        try {
            int _type = K_MAP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:827:6: ( M A P )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:827:16: M A P
            {
            mM(); 
            mA(); 
            mP(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_MAP"

    // $ANTLR start "K_LIST"
    public final void mK_LIST() throws RecognitionException {
        try {
            int _type = K_LIST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:828:7: ( L I S T )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:828:16: L I S T
            {
            mL(); 
            mI(); 
            mS(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_LIST"

    // $ANTLR start "A"
    public final void mA() throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:831:11: ( ( 'a' | 'A' ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:831:13: ( 'a' | 'A' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "A"

    // $ANTLR start "B"
    public final void mB() throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:832:11: ( ( 'b' | 'B' ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:832:13: ( 'b' | 'B' )
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "B"

    // $ANTLR start "C"
    public final void mC() throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:833:11: ( ( 'c' | 'C' ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:833:13: ( 'c' | 'C' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "C"

    // $ANTLR start "D"
    public final void mD() throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:834:11: ( ( 'd' | 'D' ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:834:13: ( 'd' | 'D' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "D"

    // $ANTLR start "E"
    public final void mE() throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:835:11: ( ( 'e' | 'E' ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:835:13: ( 'e' | 'E' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "E"

    // $ANTLR start "F"
    public final void mF() throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:836:11: ( ( 'f' | 'F' ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:836:13: ( 'f' | 'F' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "F"

    // $ANTLR start "G"
    public final void mG() throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:837:11: ( ( 'g' | 'G' ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:837:13: ( 'g' | 'G' )
            {
            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "G"

    // $ANTLR start "H"
    public final void mH() throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:838:11: ( ( 'h' | 'H' ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:838:13: ( 'h' | 'H' )
            {
            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "H"

    // $ANTLR start "I"
    public final void mI() throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:839:11: ( ( 'i' | 'I' ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:839:13: ( 'i' | 'I' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "I"

    // $ANTLR start "J"
    public final void mJ() throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:840:11: ( ( 'j' | 'J' ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:840:13: ( 'j' | 'J' )
            {
            if ( input.LA(1)=='J'||input.LA(1)=='j' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "J"

    // $ANTLR start "K"
    public final void mK() throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:841:11: ( ( 'k' | 'K' ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:841:13: ( 'k' | 'K' )
            {
            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "K"

    // $ANTLR start "L"
    public final void mL() throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:842:11: ( ( 'l' | 'L' ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:842:13: ( 'l' | 'L' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "L"

    // $ANTLR start "M"
    public final void mM() throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:843:11: ( ( 'm' | 'M' ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:843:13: ( 'm' | 'M' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "M"

    // $ANTLR start "N"
    public final void mN() throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:844:11: ( ( 'n' | 'N' ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:844:13: ( 'n' | 'N' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "N"

    // $ANTLR start "O"
    public final void mO() throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:845:11: ( ( 'o' | 'O' ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:845:13: ( 'o' | 'O' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "O"

    // $ANTLR start "P"
    public final void mP() throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:846:11: ( ( 'p' | 'P' ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:846:13: ( 'p' | 'P' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "P"

    // $ANTLR start "Q"
    public final void mQ() throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:847:11: ( ( 'q' | 'Q' ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:847:13: ( 'q' | 'Q' )
            {
            if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Q"

    // $ANTLR start "R"
    public final void mR() throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:848:11: ( ( 'r' | 'R' ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:848:13: ( 'r' | 'R' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "R"

    // $ANTLR start "S"
    public final void mS() throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:849:11: ( ( 's' | 'S' ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:849:13: ( 's' | 'S' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "S"

    // $ANTLR start "T"
    public final void mT() throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:850:11: ( ( 't' | 'T' ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:850:13: ( 't' | 'T' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "T"

    // $ANTLR start "U"
    public final void mU() throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:851:11: ( ( 'u' | 'U' ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:851:13: ( 'u' | 'U' )
            {
            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "U"

    // $ANTLR start "V"
    public final void mV() throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:852:11: ( ( 'v' | 'V' ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:852:13: ( 'v' | 'V' )
            {
            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "V"

    // $ANTLR start "W"
    public final void mW() throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:853:11: ( ( 'w' | 'W' ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:853:13: ( 'w' | 'W' )
            {
            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "W"

    // $ANTLR start "X"
    public final void mX() throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:854:11: ( ( 'x' | 'X' ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:854:13: ( 'x' | 'X' )
            {
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "X"

    // $ANTLR start "Y"
    public final void mY() throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:855:11: ( ( 'y' | 'Y' ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:855:13: ( 'y' | 'Y' )
            {
            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Y"

    // $ANTLR start "Z"
    public final void mZ() throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:856:11: ( ( 'z' | 'Z' ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:856:13: ( 'z' | 'Z' )
            {
            if ( input.LA(1)=='Z'||input.LA(1)=='z' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Z"

    // $ANTLR start "STRING_LITERAL"
    public final void mSTRING_LITERAL() throws RecognitionException {
        try {
            int _type = STRING_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            int c;

             StringBuilder b = new StringBuilder(); 
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:861:5: ( '\\'' (c=~ ( '\\'' ) | '\\'' '\\'' )* '\\'' )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:861:7: '\\'' (c=~ ( '\\'' ) | '\\'' '\\'' )* '\\''
            {
            match('\''); 
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:861:12: (c=~ ( '\\'' ) | '\\'' '\\'' )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\'') ) {
                    int LA4_1 = input.LA(2);

                    if ( (LA4_1=='\'') ) {
                        alt4=2;
                    }


                }
                else if ( ((LA4_0>='\u0000' && LA4_0<='&')||(LA4_0>='(' && LA4_0<='\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:861:13: c=~ ( '\\'' )
            	    {
            	    c= input.LA(1);
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}

            	     b.appendCodePoint(c);

            	    }
            	    break;
            	case 2 :
            	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:861:50: '\\'' '\\''
            	    {
            	    match('\''); 
            	    match('\''); 
            	     b.appendCodePoint('\''); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
             setText(b.toString());     }
        finally {
        }
    }
    // $ANTLR end "STRING_LITERAL"

    // $ANTLR start "QUOTED_NAME"
    public final void mQUOTED_NAME() throws RecognitionException {
        try {
            int _type = QUOTED_NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            int c;

             StringBuilder b = new StringBuilder(); 
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:867:5: ( '\\\"' (c=~ ( '\\\"' ) | '\\\"' '\\\"' )* '\\\"' )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:867:7: '\\\"' (c=~ ( '\\\"' ) | '\\\"' '\\\"' )* '\\\"'
            {
            match('\"'); 
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:867:12: (c=~ ( '\\\"' ) | '\\\"' '\\\"' )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\"') ) {
                    int LA5_1 = input.LA(2);

                    if ( (LA5_1=='\"') ) {
                        alt5=2;
                    }


                }
                else if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:867:13: c=~ ( '\\\"' )
            	    {
            	    c= input.LA(1);
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}

            	     b.appendCodePoint(c); 

            	    }
            	    break;
            	case 2 :
            	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:867:51: '\\\"' '\\\"'
            	    {
            	    match('\"'); 
            	    match('\"'); 
            	     b.appendCodePoint('\"'); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
             setText(b.toString());     }
        finally {
        }
    }
    // $ANTLR end "QUOTED_NAME"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:871:5: ( '0' .. '9' )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:871:7: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:875:5: ( ( 'A' .. 'Z' | 'a' .. 'z' ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:875:7: ( 'A' .. 'Z' | 'a' .. 'z' )
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "HEX"
    public final void mHEX() throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:879:5: ( ( 'A' .. 'F' | 'a' .. 'f' | '0' .. '9' ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:879:7: ( 'A' .. 'F' | 'a' .. 'f' | '0' .. '9' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "HEX"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:883:5: ( ( '-' )? ( DIGIT )+ )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:883:7: ( '-' )? ( DIGIT )+
            {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:883:7: ( '-' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='-') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:883:7: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:883:12: ( DIGIT )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:883:12: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "QMARK"
    public final void mQMARK() throws RecognitionException {
        try {
            int _type = QMARK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:887:5: ( '?' )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:887:7: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QMARK"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:895:5: ( INTEGER '.' ( DIGIT )* )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:895:7: INTEGER '.' ( DIGIT )*
            {
            mINTEGER(); 
            match('.'); 
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:895:19: ( DIGIT )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:895:19: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:899:5: ( LETTER ( LETTER | DIGIT | '_' )* )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:899:7: LETTER ( LETTER | DIGIT | '_' )*
            {
            mLETTER(); 
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:899:14: ( LETTER | DIGIT | '_' )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='0' && LA9_0<='9')||(LA9_0>='A' && LA9_0<='Z')||LA9_0=='_'||(LA9_0>='a' && LA9_0<='z')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "UUID"
    public final void mUUID() throws RecognitionException {
        try {
            int _type = UUID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:903:5: ( HEX HEX HEX HEX HEX HEX HEX HEX '-' HEX HEX HEX HEX '-' HEX HEX HEX HEX '-' HEX HEX HEX HEX '-' HEX HEX HEX HEX HEX HEX HEX HEX HEX HEX HEX HEX )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:903:7: HEX HEX HEX HEX HEX HEX HEX HEX '-' HEX HEX HEX HEX '-' HEX HEX HEX HEX '-' HEX HEX HEX HEX '-' HEX HEX HEX HEX HEX HEX HEX HEX HEX HEX HEX HEX
            {
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            match('-'); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            match('-'); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            match('-'); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            match('-'); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UUID"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:911:5: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:911:7: ( ' ' | '\\t' | '\\n' | '\\r' )+
            {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:911:7: ( ' ' | '\\t' | '\\n' | '\\r' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\t' && LA10_0<='\n')||LA10_0=='\r'||LA10_0==' ') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:915:5: ( ( '--' | '//' ) ( . )* ( '\\n' | '\\r' ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:915:7: ( '--' | '//' ) ( . )* ( '\\n' | '\\r' )
            {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:915:7: ( '--' | '//' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='-') ) {
                alt11=1;
            }
            else if ( (LA11_0=='/') ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:915:8: '--'
                    {
                    match("--"); 


                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:915:15: '//'
                    {
                    match("//"); 


                    }
                    break;

            }

            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:915:21: ( . )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='\n'||LA12_0=='\r') ) {
                    alt12=2;
                }
                else if ( ((LA12_0>='\u0000' && LA12_0<='\t')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:915:21: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "MULTILINE_COMMENT"
    public final void mMULTILINE_COMMENT() throws RecognitionException {
        try {
            int _type = MULTILINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:919:5: ( '/*' ( . )* '*/' )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:919:7: '/*' ( . )* '*/'
            {
            match("/*"); 

            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:919:12: ( . )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0=='*') ) {
                    int LA13_1 = input.LA(2);

                    if ( (LA13_1=='/') ) {
                        alt13=2;
                    }
                    else if ( ((LA13_1>='\u0000' && LA13_1<='.')||(LA13_1>='0' && LA13_1<='\uFFFF')) ) {
                        alt13=1;
                    }


                }
                else if ( ((LA13_0>='\u0000' && LA13_0<=')')||(LA13_0>='+' && LA13_0<='\uFFFF')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:919:12: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            match("*/"); 

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MULTILINE_COMMENT"

    public void mTokens() throws RecognitionException {
        // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:8: ( T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | T__129 | T__130 | K_SELECT | K_FROM | K_WHERE | K_AND | K_KEY | K_INSERT | K_UPDATE | K_WITH | K_LIMIT | K_USING | K_CONSISTENCY | K_LEVEL | K_USE | K_COUNT | K_SET | K_BEGIN | K_APPLY | K_BATCH | K_TRUNCATE | K_DELETE | K_IN | K_CREATE | K_KEYSPACE | K_COLUMNFAMILY | K_INDEX | K_ON | K_TO | K_DROP | K_PRIMARY | K_INTO | K_VALUES | K_TIMESTAMP | K_TTL | K_ALTER | K_ADD | K_TYPE | K_COMPACT | K_STORAGE | K_ORDER | K_BY | K_ASC | K_DESC | K_GRANT | K_GRANTS | K_REVOKE | K_OPTION | K_DESCRIBE | K_FOR | K_FULL_ACCESS | K_NO_ACCESS | K_CLUSTERING | K_ASCII | K_BIGINT | K_BLOB | K_BOOLEAN | K_COUNTER | K_DECIMAL | K_DOUBLE | K_FLOAT | K_INET | K_INT | K_TEXT | K_UUID | K_VARCHAR | K_VARINT | K_TIMEUUID | K_TOKEN | K_WRITETIME | K_MAP | K_LIST | STRING_LITERAL | QUOTED_NAME | INTEGER | QMARK | FLOAT | IDENT | UUID | WS | COMMENT | MULTILINE_COMMENT )
        int alt14=98;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:10: T__113
                {
                mT__113(); 

                }
                break;
            case 2 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:17: T__114
                {
                mT__114(); 

                }
                break;
            case 3 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:24: T__115
                {
                mT__115(); 

                }
                break;
            case 4 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:31: T__116
                {
                mT__116(); 

                }
                break;
            case 5 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:38: T__117
                {
                mT__117(); 

                }
                break;
            case 6 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:45: T__118
                {
                mT__118(); 

                }
                break;
            case 7 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:52: T__119
                {
                mT__119(); 

                }
                break;
            case 8 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:59: T__120
                {
                mT__120(); 

                }
                break;
            case 9 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:66: T__121
                {
                mT__121(); 

                }
                break;
            case 10 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:73: T__122
                {
                mT__122(); 

                }
                break;
            case 11 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:80: T__123
                {
                mT__123(); 

                }
                break;
            case 12 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:87: T__124
                {
                mT__124(); 

                }
                break;
            case 13 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:94: T__125
                {
                mT__125(); 

                }
                break;
            case 14 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:101: T__126
                {
                mT__126(); 

                }
                break;
            case 15 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:108: T__127
                {
                mT__127(); 

                }
                break;
            case 16 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:115: T__128
                {
                mT__128(); 

                }
                break;
            case 17 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:122: T__129
                {
                mT__129(); 

                }
                break;
            case 18 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:129: T__130
                {
                mT__130(); 

                }
                break;
            case 19 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:136: K_SELECT
                {
                mK_SELECT(); 

                }
                break;
            case 20 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:145: K_FROM
                {
                mK_FROM(); 

                }
                break;
            case 21 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:152: K_WHERE
                {
                mK_WHERE(); 

                }
                break;
            case 22 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:160: K_AND
                {
                mK_AND(); 

                }
                break;
            case 23 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:166: K_KEY
                {
                mK_KEY(); 

                }
                break;
            case 24 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:172: K_INSERT
                {
                mK_INSERT(); 

                }
                break;
            case 25 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:181: K_UPDATE
                {
                mK_UPDATE(); 

                }
                break;
            case 26 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:190: K_WITH
                {
                mK_WITH(); 

                }
                break;
            case 27 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:197: K_LIMIT
                {
                mK_LIMIT(); 

                }
                break;
            case 28 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:205: K_USING
                {
                mK_USING(); 

                }
                break;
            case 29 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:213: K_CONSISTENCY
                {
                mK_CONSISTENCY(); 

                }
                break;
            case 30 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:227: K_LEVEL
                {
                mK_LEVEL(); 

                }
                break;
            case 31 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:235: K_USE
                {
                mK_USE(); 

                }
                break;
            case 32 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:241: K_COUNT
                {
                mK_COUNT(); 

                }
                break;
            case 33 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:249: K_SET
                {
                mK_SET(); 

                }
                break;
            case 34 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:255: K_BEGIN
                {
                mK_BEGIN(); 

                }
                break;
            case 35 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:263: K_APPLY
                {
                mK_APPLY(); 

                }
                break;
            case 36 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:271: K_BATCH
                {
                mK_BATCH(); 

                }
                break;
            case 37 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:279: K_TRUNCATE
                {
                mK_TRUNCATE(); 

                }
                break;
            case 38 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:290: K_DELETE
                {
                mK_DELETE(); 

                }
                break;
            case 39 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:299: K_IN
                {
                mK_IN(); 

                }
                break;
            case 40 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:304: K_CREATE
                {
                mK_CREATE(); 

                }
                break;
            case 41 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:313: K_KEYSPACE
                {
                mK_KEYSPACE(); 

                }
                break;
            case 42 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:324: K_COLUMNFAMILY
                {
                mK_COLUMNFAMILY(); 

                }
                break;
            case 43 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:339: K_INDEX
                {
                mK_INDEX(); 

                }
                break;
            case 44 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:347: K_ON
                {
                mK_ON(); 

                }
                break;
            case 45 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:352: K_TO
                {
                mK_TO(); 

                }
                break;
            case 46 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:357: K_DROP
                {
                mK_DROP(); 

                }
                break;
            case 47 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:364: K_PRIMARY
                {
                mK_PRIMARY(); 

                }
                break;
            case 48 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:374: K_INTO
                {
                mK_INTO(); 

                }
                break;
            case 49 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:381: K_VALUES
                {
                mK_VALUES(); 

                }
                break;
            case 50 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:390: K_TIMESTAMP
                {
                mK_TIMESTAMP(); 

                }
                break;
            case 51 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:402: K_TTL
                {
                mK_TTL(); 

                }
                break;
            case 52 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:408: K_ALTER
                {
                mK_ALTER(); 

                }
                break;
            case 53 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:416: K_ADD
                {
                mK_ADD(); 

                }
                break;
            case 54 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:422: K_TYPE
                {
                mK_TYPE(); 

                }
                break;
            case 55 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:429: K_COMPACT
                {
                mK_COMPACT(); 

                }
                break;
            case 56 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:439: K_STORAGE
                {
                mK_STORAGE(); 

                }
                break;
            case 57 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:449: K_ORDER
                {
                mK_ORDER(); 

                }
                break;
            case 58 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:457: K_BY
                {
                mK_BY(); 

                }
                break;
            case 59 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:462: K_ASC
                {
                mK_ASC(); 

                }
                break;
            case 60 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:468: K_DESC
                {
                mK_DESC(); 

                }
                break;
            case 61 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:475: K_GRANT
                {
                mK_GRANT(); 

                }
                break;
            case 62 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:483: K_GRANTS
                {
                mK_GRANTS(); 

                }
                break;
            case 63 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:492: K_REVOKE
                {
                mK_REVOKE(); 

                }
                break;
            case 64 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:501: K_OPTION
                {
                mK_OPTION(); 

                }
                break;
            case 65 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:510: K_DESCRIBE
                {
                mK_DESCRIBE(); 

                }
                break;
            case 66 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:521: K_FOR
                {
                mK_FOR(); 

                }
                break;
            case 67 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:527: K_FULL_ACCESS
                {
                mK_FULL_ACCESS(); 

                }
                break;
            case 68 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:541: K_NO_ACCESS
                {
                mK_NO_ACCESS(); 

                }
                break;
            case 69 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:553: K_CLUSTERING
                {
                mK_CLUSTERING(); 

                }
                break;
            case 70 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:566: K_ASCII
                {
                mK_ASCII(); 

                }
                break;
            case 71 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:574: K_BIGINT
                {
                mK_BIGINT(); 

                }
                break;
            case 72 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:583: K_BLOB
                {
                mK_BLOB(); 

                }
                break;
            case 73 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:590: K_BOOLEAN
                {
                mK_BOOLEAN(); 

                }
                break;
            case 74 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:600: K_COUNTER
                {
                mK_COUNTER(); 

                }
                break;
            case 75 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:610: K_DECIMAL
                {
                mK_DECIMAL(); 

                }
                break;
            case 76 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:620: K_DOUBLE
                {
                mK_DOUBLE(); 

                }
                break;
            case 77 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:629: K_FLOAT
                {
                mK_FLOAT(); 

                }
                break;
            case 78 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:637: K_INET
                {
                mK_INET(); 

                }
                break;
            case 79 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:644: K_INT
                {
                mK_INT(); 

                }
                break;
            case 80 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:650: K_TEXT
                {
                mK_TEXT(); 

                }
                break;
            case 81 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:657: K_UUID
                {
                mK_UUID(); 

                }
                break;
            case 82 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:664: K_VARCHAR
                {
                mK_VARCHAR(); 

                }
                break;
            case 83 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:674: K_VARINT
                {
                mK_VARINT(); 

                }
                break;
            case 84 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:683: K_TIMEUUID
                {
                mK_TIMEUUID(); 

                }
                break;
            case 85 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:694: K_TOKEN
                {
                mK_TOKEN(); 

                }
                break;
            case 86 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:702: K_WRITETIME
                {
                mK_WRITETIME(); 

                }
                break;
            case 87 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:714: K_MAP
                {
                mK_MAP(); 

                }
                break;
            case 88 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:720: K_LIST
                {
                mK_LIST(); 

                }
                break;
            case 89 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:727: STRING_LITERAL
                {
                mSTRING_LITERAL(); 

                }
                break;
            case 90 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:742: QUOTED_NAME
                {
                mQUOTED_NAME(); 

                }
                break;
            case 91 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:754: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 92 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:762: QMARK
                {
                mQMARK(); 

                }
                break;
            case 93 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:768: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 94 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:774: IDENT
                {
                mIDENT(); 

                }
                break;
            case 95 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:780: UUID
                {
                mUUID(); 

                }
                break;
            case 96 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:785: WS
                {
                mWS(); 

                }
                break;
            case 97 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:788: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 98 :
                // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:1:796: MULTILINE_COMMENT
                {
                mMULTILINE_COMMENT(); 

                }
                break;

        }

    }


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA1_eotS =
        "\13\uffff";
    static final String DFA1_eofS =
        "\13\uffff";
    static final String DFA1_minS =
        "\1\101\2\uffff\1\114\2\uffff\1\110\4\uffff";
    static final String DFA1_maxS =
        "\1\164\2\uffff\1\156\2\uffff\1\167\4\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\5\1\6\1\uffff\1\4\1\3\1\10\1\7";
    static final String DFA1_specialS =
        "\13\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\3\3\uffff\1\5\6\uffff\1\4\2\uffff\1\1\1\uffff\1\2\2\uffff"+
            "\1\6\14\uffff\1\3\3\uffff\1\5\6\uffff\1\4\2\uffff\1\1\1\uffff"+
            "\1\2\2\uffff\1\6",
            "",
            "",
            "\1\10\1\uffff\1\7\35\uffff\1\10\1\uffff\1\7",
            "",
            "",
            "\1\11\16\uffff\1\12\20\uffff\1\11\16\uffff\1\12",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "756:16: ( O N E | Q U O R U M | A L L | A N Y | L O C A L '_' Q U O R U M | E A C H '_' Q U O R U M | T W O | T H R E E )";
        }
    }
    static final String DFA14_eotS =
        "\16\uffff\1\57\1\61\1\63\25\52\2\uffff\1\153\5\uffff\1\153\5\uffff"+
        "\21\52\1\u0084\10\52\1\u0096\6\52\1\u009e\10\52\1\u00a8\14\52\1"+
        "\uffff\1\153\3\uffff\2\52\1\u00bb\2\52\1\u00be\6\52\1\u00c5\1\52"+
        "\1\u00c8\1\52\1\u00c8\1\u00ca\1\u00cb\1\u00cc\1\uffff\1\u00ce\4"+
        "\52\1\u00d4\13\52\1\uffff\1\u00c8\5\52\1\u00c8\1\uffff\3\52\1\u00e8"+
        "\5\52\1\uffff\16\52\1\u00fd\1\153\2\52\1\uffff\2\52\1\uffff\2\52"+
        "\1\u0105\1\u0106\2\52\1\uffff\2\52\1\uffff\1\52\3\uffff\1\52\1\uffff"+
        "\1\u010d\1\52\1\u010f\2\52\1\uffff\1\52\1\u0113\1\u0114\20\52\1"+
        "\uffff\1\52\1\u0127\1\u0128\4\52\1\u012d\2\52\1\u0130\1\52\1\u0133"+
        "\7\52\1\uffff\1\153\3\52\1\u013f\2\52\2\uffff\1\52\1\u0143\1\u0144"+
        "\1\u0145\1\u0146\1\52\1\uffff\1\52\1\uffff\1\u0149\1\u014a\1\52"+
        "\2\uffff\1\u014c\4\52\1\u0151\3\52\1\u0156\4\52\1\u015b\1\u00c8"+
        "\1\u015c\1\52\2\uffff\1\52\1\u015f\1\u0160\1\52\1\uffff\2\52\1\uffff"+
        "\2\52\1\uffff\4\52\1\u016a\2\52\1\153\1\52\1\u0170\1\u0171\1\uffff"+
        "\3\52\4\uffff\1\52\1\u0176\2\uffff\1\u0177\1\uffff\4\52\1\uffff"+
        "\2\52\1\u017e\1\u017f\1\uffff\1\u00c8\3\52\2\uffff\2\52\2\uffff"+
        "\1\u0185\1\52\1\u0187\1\52\1\u0189\1\52\1\u018b\1\u018c\1\52\1\uffff"+
        "\1\u018e\1\u018f\1\52\1\153\1\u0192\2\uffff\4\52\2\uffff\1\52\1"+
        "\u0198\2\52\1\u019b\1\52\2\uffff\4\52\1\u01a1\1\uffff\1\u01a2\1"+
        "\uffff\1\52\1\uffff\1\u01a4\2\uffff\1\u01a5\2\uffff\1\52\1\153\1"+
        "\uffff\3\52\1\u0171\1\52\1\uffff\2\52\1\uffff\3\52\1\u01b0\1\u01b1"+
        "\2\uffff\1\u01b2\2\uffff\1\52\1\153\1\52\1\u01b5\5\52\1\u01bb\3"+
        "\uffff\1\u01bc\1\52\1\uffff\3\52\1\u01c1\1\52\2\uffff\1\u01c3\2"+
        "\52\1\u01c6\1\uffff\1\u00c8\1\uffff\1\u00c8\1\u015c\1\uffff";
    static final String DFA14_eofS =
        "\u01c7\uffff";
    static final String DFA14_minS =
        "\1\11\15\uffff\1\55\2\75\1\103\1\60\1\110\1\60\1\105\1\116\1\120"+
        "\1\111\1\60\1\116\1\125\1\60\1\101\2\60\1\122\1\101\1\122\1\105"+
        "\1\117\1\101\2\uffff\1\56\3\uffff\1\52\1\uffff\1\56\5\uffff\1\117"+
        "\1\114\1\110\1\117\1\122\1\60\1\114\1\117\1\124\1\111\1\105\1\103"+
        "\1\114\1\120\1\104\1\60\1\131\1\60\1\105\1\104\1\111\1\115\1\103"+
        "\1\114\1\125\1\105\1\60\1\124\1\104\1\117\1\60\1\115\1\117\1\60"+
        "\1\122\1\102\1\114\1\125\1\120\1\130\1\117\3\60\1\107\1\117\1\60"+
        "\1\125\1\117\1\111\1\114\1\101\1\126\1\137\1\120\1\uffff\1\56\3"+
        "\uffff\1\122\1\105\1\60\1\105\1\101\2\60\1\114\1\115\1\110\1\124"+
        "\1\122\1\60\1\105\1\60\1\114\4\60\1\uffff\1\60\1\105\1\124\1\105"+
        "\1\116\1\60\1\101\1\104\1\124\1\111\1\101\1\120\1\125\1\123\1\116"+
        "\1\123\1\101\1\uffff\1\60\1\111\1\105\1\122\1\60\1\105\1\60\1\uffff"+
        "\2\105\1\114\1\60\1\116\1\105\1\124\1\114\1\103\1\uffff\2\111\1"+
        "\102\1\60\1\105\1\103\1\102\1\120\1\115\1\125\1\103\1\116\1\117"+
        "\1\101\1\60\1\56\1\101\1\103\1\uffff\1\115\1\124\1\uffff\1\60\1"+
        "\137\2\60\2\105\1\uffff\1\111\1\122\1\uffff\1\131\3\uffff\1\120"+
        "\1\uffff\1\60\1\122\1\60\1\130\1\107\1\uffff\1\124\2\60\1\124\1"+
        "\114\1\101\1\115\1\111\3\124\1\117\1\122\1\125\1\137\1\123\1\116"+
        "\2\105\1\uffff\1\103\2\60\1\105\1\110\2\116\1\60\1\115\1\124\1\60"+
        "\1\114\1\60\1\101\1\105\1\116\1\110\1\124\1\113\1\103\1\uffff\1"+
        "\56\1\107\1\124\1\101\2\60\1\101\2\uffff\1\124\4\60\1\101\1\uffff"+
        "\1\124\1\uffff\2\60\1\105\2\uffff\1\60\1\137\1\103\1\116\1\123\1"+
        "\60\2\105\1\116\1\60\1\115\1\121\1\124\1\125\3\60\1\101\2\uffff"+
        "\1\101\2\60\1\124\1\uffff\1\101\1\105\1\uffff\1\111\1\105\1\uffff"+
        "\1\122\1\123\1\124\1\101\1\60\1\105\1\103\1\56\1\105\2\60\1\uffff"+
        "\1\60\1\103\1\111\4\uffff\1\103\1\60\2\uffff\1\60\1\uffff\1\121"+
        "\1\124\1\106\1\124\1\uffff\2\122\2\60\1\uffff\1\60\1\125\1\101\1"+
        "\111\2\uffff\1\124\1\116\2\uffff\1\60\1\114\1\60\1\102\1\60\1\131"+
        "\2\60\1\122\1\uffff\2\60\1\105\1\56\1\60\2\uffff\1\60\1\103\1\115"+
        "\1\105\2\uffff\1\125\1\60\1\101\1\105\1\60\1\111\2\uffff\1\117\1"+
        "\115\1\104\1\105\1\60\1\uffff\1\60\1\uffff\1\105\1\uffff\1\60\2"+
        "\uffff\1\60\2\uffff\1\123\1\56\1\uffff\1\55\2\105\1\60\1\117\1\uffff"+
        "\1\115\1\116\1\uffff\1\116\1\122\1\120\2\60\2\uffff\1\60\2\uffff"+
        "\1\123\1\55\1\123\1\60\1\122\1\111\1\103\1\107\1\125\1\60\3\uffff"+
        "\1\60\1\123\1\uffff\1\125\1\114\1\131\1\60\1\115\2\uffff\1\60\1"+
        "\115\1\131\1\60\1\uffff\1\60\1\uffff\2\60\1\uffff";
    static final String DFA14_maxS =
        "\1\175\15\uffff\1\71\2\75\1\164\1\165\1\162\1\163\1\145\1\156\1"+
        "\165\1\157\2\162\1\165\1\146\2\171\2\162\1\141\1\162\1\145\1\157"+
        "\1\141\2\uffff\1\146\3\uffff\1\57\1\uffff\1\71\5\uffff\1\157\1\164"+
        "\1\150\1\157\1\162\1\146\1\154\1\157\1\164\1\151\1\145\1\143\1\164"+
        "\1\160\1\171\1\146\1\171\1\172\1\151\1\144\1\151\1\163\1\143\2\165"+
        "\1\145\1\172\1\164\1\144\1\157\1\146\1\155\1\157\1\172\1\162\1\142"+
        "\1\154\1\165\1\160\1\170\1\157\1\164\1\172\2\147\1\157\1\163\1\165"+
        "\1\157\1\151\1\162\1\141\1\166\1\137\1\160\1\uffff\1\146\3\uffff"+
        "\1\162\1\145\1\172\1\145\1\141\1\172\1\146\1\154\1\155\1\150\1\164"+
        "\1\162\1\172\1\145\1\172\1\154\4\172\1\uffff\1\172\1\145\1\164\1"+
        "\145\1\156\1\172\1\141\1\144\1\164\1\151\1\141\1\160\1\165\1\163"+
        "\1\156\1\163\1\141\1\uffff\1\172\1\151\1\145\1\162\1\150\1\145\1"+
        "\172\1\uffff\2\145\1\154\1\172\1\156\1\145\1\164\1\154\1\143\1\uffff"+
        "\2\151\1\142\1\151\1\145\1\143\1\142\1\160\1\155\1\165\1\151\1\156"+
        "\1\157\1\141\1\172\1\146\1\141\1\143\1\uffff\1\155\1\164\1\uffff"+
        "\1\146\1\137\2\172\2\145\1\uffff\1\151\1\162\1\uffff\1\171\3\uffff"+
        "\1\160\1\uffff\1\172\1\162\1\172\1\170\1\147\1\uffff\1\164\2\172"+
        "\1\164\1\154\1\141\1\155\1\151\3\164\1\157\1\162\1\165\1\137\1\165"+
        "\1\156\2\145\1\uffff\1\143\2\172\1\145\1\150\2\156\1\172\1\155\1"+
        "\164\1\172\1\154\1\172\1\141\1\145\1\156\1\150\1\164\1\153\1\143"+
        "\1\uffff\1\146\1\147\1\164\1\141\1\172\1\146\1\141\2\uffff\1\164"+
        "\4\172\1\141\1\uffff\1\164\1\uffff\2\172\1\145\2\uffff\1\172\1\137"+
        "\1\143\1\156\1\163\1\172\2\145\1\156\1\172\1\155\1\161\1\164\1\165"+
        "\3\172\1\141\2\uffff\1\141\2\172\1\164\1\uffff\1\141\1\145\1\uffff"+
        "\1\151\1\145\1\uffff\1\162\1\163\1\164\1\141\1\172\1\145\1\143\1"+
        "\146\1\145\2\172\1\uffff\1\146\1\143\1\151\4\uffff\1\143\1\172\2"+
        "\uffff\1\172\1\uffff\1\161\1\164\1\146\1\164\1\uffff\2\162\2\172"+
        "\1\uffff\1\172\1\165\1\141\1\151\2\uffff\1\164\1\156\2\uffff\1\172"+
        "\1\154\1\172\1\142\1\172\1\171\2\172\1\162\1\uffff\2\172\1\145\1"+
        "\146\1\172\2\uffff\1\146\1\143\1\155\1\145\2\uffff\1\165\1\172\1"+
        "\141\1\145\1\172\1\151\2\uffff\1\157\1\155\1\144\1\145\1\172\1\uffff"+
        "\1\172\1\uffff\1\145\1\uffff\1\172\2\uffff\1\172\2\uffff\1\163\1"+
        "\146\1\uffff\1\55\2\145\1\172\1\157\1\uffff\1\155\1\156\1\uffff"+
        "\1\156\1\162\1\160\2\172\2\uffff\1\172\2\uffff\1\163\1\71\1\163"+
        "\1\172\1\162\1\151\1\143\1\147\1\165\1\172\3\uffff\1\172\1\163\1"+
        "\uffff\1\165\1\154\1\171\1\172\1\155\2\uffff\1\172\1\155\1\171\1"+
        "\172\1\uffff\1\172\1\uffff\2\172\1\uffff";
    static final String DFA14_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1"+
        "\15\30\uffff\1\131\1\132\1\uffff\1\134\1\136\1\140\1\uffff\1\141"+
        "\1\uffff\1\16\1\20\1\17\1\21\1\22\67\uffff\1\133\1\uffff\1\137\1"+
        "\135\1\142\24\uffff\1\47\21\uffff\1\54\7\uffff\1\55\11\uffff\1\72"+
        "\22\uffff\1\41\2\uffff\1\102\6\uffff\1\73\2\uffff\1\36\1\uffff\1"+
        "\26\1\65\1\27\1\uffff\1\117\5\uffff\1\37\23\uffff\1\63\24\uffff"+
        "\1\127\7\uffff\1\24\1\32\6\uffff\1\60\1\uffff\1\116\3\uffff\1\121"+
        "\1\130\22\uffff\1\66\1\120\4\uffff\1\110\2\uffff\1\74\2\uffff\1"+
        "\56\13\uffff\1\115\3\uffff\1\25\1\106\1\64\1\43\2\uffff\1\53\1\34"+
        "\1\uffff\1\33\4\uffff\1\40\4\uffff\1\71\4\uffff\1\125\1\52\2\uffff"+
        "\1\44\1\42\11\uffff\1\75\5\uffff\1\23\1\51\4\uffff\1\30\1\31\6\uffff"+
        "\1\50\1\100\5\uffff\1\107\1\uffff\1\46\1\uffff\1\114\1\uffff\1\61"+
        "\1\123\1\uffff\1\76\1\77\2\uffff\1\70\5\uffff\1\67\2\uffff\1\112"+
        "\5\uffff\1\111\1\113\1\uffff\1\57\1\122\12\uffff\1\124\1\45\1\101"+
        "\2\uffff\1\126\5\uffff\1\62\1\104\4\uffff\1\105\1\uffff\1\103\2"+
        "\uffff\1\35";
    static final String DFA14_specialS =
        "\u01c7\uffff}>";
    static final String[] DFA14_transitionS = {
            "\2\53\2\uffff\1\53\22\uffff\1\53\1\uffff\1\47\4\uffff\1\46\1"+
            "\2\1\3\1\5\1\15\1\4\1\16\1\10\1\54\12\50\1\13\1\1\1\17\1\14"+
            "\1\20\1\51\1\uffff\1\24\1\36\1\31\1\37\1\34\1\22\1\42\1\52\1"+
            "\26\1\52\1\25\1\30\1\45\1\44\1\32\1\40\1\33\1\43\1\21\1\35\1"+
            "\27\1\41\1\23\3\52\1\6\1\uffff\1\7\3\uffff\1\24\1\36\1\31\1"+
            "\37\1\34\1\22\1\42\1\52\1\26\1\52\1\25\1\30\1\45\1\44\1\32\1"+
            "\40\1\33\1\43\1\21\1\35\1\27\1\41\1\23\3\52\1\11\1\uffff\1\12",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\55\2\uffff\12\56",
            "\1\60",
            "\1\62",
            "\1\66\1\uffff\1\65\16\uffff\1\64\16\uffff\1\66\1\uffff\1\65"+
            "\16\uffff\1\64",
            "\12\71\7\uffff\6\71\5\uffff\1\67\2\uffff\1\70\2\uffff\1\73"+
            "\2\uffff\1\72\13\uffff\6\71\5\uffff\1\67\2\uffff\1\70\2\uffff"+
            "\1\73\2\uffff\1\72",
            "\1\76\1\74\10\uffff\1\75\25\uffff\1\76\1\74\10\uffff\1\75",
            "\12\71\7\uffff\3\71\1\103\2\71\5\uffff\1\100\1\uffff\1\102"+
            "\1\uffff\1\101\2\uffff\1\77\15\uffff\3\71\1\103\2\71\5\uffff"+
            "\1\100\1\uffff\1\102\1\uffff\1\101\2\uffff\1\77",
            "\1\104\37\uffff\1\104",
            "\1\105\37\uffff\1\105",
            "\1\107\2\uffff\1\106\1\uffff\1\110\32\uffff\1\107\2\uffff\1"+
            "\106\1\uffff\1\110",
            "\1\111\5\uffff\1\112\31\uffff\1\111\5\uffff\1\112",
            "\12\71\7\uffff\6\71\5\uffff\1\114\2\uffff\1\113\2\uffff\1\115"+
            "\16\uffff\6\71\5\uffff\1\114\2\uffff\1\113\2\uffff\1\115",
            "\1\116\1\uffff\1\117\1\uffff\1\120\33\uffff\1\116\1\uffff\1"+
            "\117\1\uffff\1\120",
            "\1\121\37\uffff\1\121",
            "\12\71\7\uffff\1\122\5\71\32\uffff\1\122\5\71",
            "\1\127\3\uffff\1\133\2\uffff\1\126\1\123\5\uffff\1\125\2\uffff"+
            "\1\131\1\uffff\1\130\2\uffff\1\124\1\uffff\1\132\7\uffff\1\127"+
            "\3\uffff\1\133\2\uffff\1\126\1\123\5\uffff\1\125\2\uffff\1\131"+
            "\1\uffff\1\130\2\uffff\1\124\1\uffff\1\132",
            "\12\71\7\uffff\1\135\3\71\1\137\1\71\2\uffff\1\140\2\uffff"+
            "\1\141\2\uffff\1\134\11\uffff\1\136\7\uffff\1\135\3\71\1\137"+
            "\1\71\2\uffff\1\140\2\uffff\1\141\2\uffff\1\134\11\uffff\1\136",
            "\12\71\7\uffff\4\71\1\142\1\71\10\uffff\1\143\2\uffff\1\144"+
            "\16\uffff\4\71\1\142\1\71\10\uffff\1\143\2\uffff\1\144",
            "\1\145\37\uffff\1\145",
            "\1\146\37\uffff\1\146",
            "\1\147\37\uffff\1\147",
            "\1\150\37\uffff\1\150",
            "\1\151\37\uffff\1\151",
            "\1\152\37\uffff\1\152",
            "",
            "",
            "\1\156\1\uffff\12\154\7\uffff\6\155\32\uffff\6\155",
            "",
            "",
            "",
            "\1\157\4\uffff\1\55",
            "",
            "\1\156\1\uffff\12\56",
            "",
            "",
            "",
            "",
            "",
            "\1\160\37\uffff\1\160",
            "\1\161\7\uffff\1\162\27\uffff\1\161\7\uffff\1\162",
            "\1\163\37\uffff\1\163",
            "\1\164\37\uffff\1\164",
            "\1\165\37\uffff\1\165",
            "\12\166\7\uffff\6\166\32\uffff\6\166",
            "\1\167\37\uffff\1\167",
            "\1\170\37\uffff\1\170",
            "\1\171\37\uffff\1\171",
            "\1\172\37\uffff\1\172",
            "\1\173\37\uffff\1\173",
            "\1\174\37\uffff\1\174",
            "\1\176\7\uffff\1\175\27\uffff\1\176\7\uffff\1\175",
            "\1\177\37\uffff\1\177",
            "\1\u0081\24\uffff\1\u0080\12\uffff\1\u0081\24\uffff\1\u0080",
            "\12\166\7\uffff\3\166\1\u0082\2\166\32\uffff\3\166\1\u0082"+
            "\2\166",
            "\1\u0083\37\uffff\1\u0083",
            "\12\52\7\uffff\3\52\1\u0088\1\u0087\15\52\1\u0086\1\u0085\6"+
            "\52\4\uffff\1\52\1\uffff\3\52\1\u0088\1\u0087\15\52\1\u0086"+
            "\1\u0085\6\52",
            "\1\u008a\3\uffff\1\u0089\33\uffff\1\u008a\3\uffff\1\u0089",
            "\1\u008b\37\uffff\1\u008b",
            "\1\u008c\37\uffff\1\u008c",
            "\1\u008e\5\uffff\1\u008d\31\uffff\1\u008e\5\uffff\1\u008d",
            "\1\u008f\37\uffff\1\u008f",
            "\1\u0091\1\u0090\1\u0092\6\uffff\1\u0093\26\uffff\1\u0091\1"+
            "\u0090\1\u0092\6\uffff\1\u0093",
            "\1\u0094\37\uffff\1\u0094",
            "\1\u0095\37\uffff\1\u0095",
            "\12\52\7\uffff\4\52\1\u0097\25\52\4\uffff\1\52\1\uffff\4\52"+
            "\1\u0097\25\52",
            "\1\u0098\37\uffff\1\u0098",
            "\1\u0099\37\uffff\1\u0099",
            "\1\u009a\37\uffff\1\u009a",
            "\12\166\7\uffff\2\166\1\u009b\3\166\32\uffff\2\166\1\u009b"+
            "\3\166",
            "\1\u009c\37\uffff\1\u009c",
            "\1\u009d\37\uffff\1\u009d",
            "\12\52\7\uffff\12\52\1\u009f\17\52\4\uffff\1\52\1\uffff\12"+
            "\52\1\u009f\17\52",
            "\1\u00a0\37\uffff\1\u00a0",
            "\1\u00a1\37\uffff\1\u00a1",
            "\1\u00a2\37\uffff\1\u00a2",
            "\1\u00a3\37\uffff\1\u00a3",
            "\1\u00a4\37\uffff\1\u00a4",
            "\1\u00a5\37\uffff\1\u00a5",
            "\1\u00a6\37\uffff\1\u00a6",
            "\12\166\7\uffff\6\166\15\uffff\1\u00a7\14\uffff\6\166\15\uffff"+
            "\1\u00a7",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\166\7\uffff\6\166\1\u00a9\31\uffff\6\166\1\u00a9",
            "\1\u00aa\37\uffff\1\u00aa",
            "\1\u00ab\37\uffff\1\u00ab",
            "\12\166\7\uffff\2\166\1\u00ac\3\166\5\uffff\1\u00ad\6\uffff"+
            "\1\u00ae\15\uffff\2\166\1\u00ac\3\166\5\uffff\1\u00ad\6\uffff"+
            "\1\u00ae",
            "\1\u00af\37\uffff\1\u00af",
            "\1\u00b0\37\uffff\1\u00b0",
            "\1\u00b1\37\uffff\1\u00b1",
            "\1\u00b2\5\uffff\1\u00b3\31\uffff\1\u00b2\5\uffff\1\u00b3",
            "\1\u00b4\37\uffff\1\u00b4",
            "\1\u00b5\37\uffff\1\u00b5",
            "\1\u00b6",
            "\1\u00b7\37\uffff\1\u00b7",
            "",
            "\1\156\1\uffff\12\u00b8\7\uffff\6\155\32\uffff\6\155",
            "",
            "",
            "",
            "\1\u00b9\37\uffff\1\u00b9",
            "\1\u00ba\37\uffff\1\u00ba",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u00bc\37\uffff\1\u00bc",
            "\1\u00bd\37\uffff\1\u00bd",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\u00bf\7\uffff\6\u00bf\32\uffff\6\u00bf",
            "\1\u00c0\37\uffff\1\u00c0",
            "\1\u00c1\37\uffff\1\u00c1",
            "\1\u00c2\37\uffff\1\u00c2",
            "\1\u00c3\37\uffff\1\u00c3",
            "\1\u00c4\37\uffff\1\u00c4",
            "\12\52\7\uffff\10\52\1\u00c6\21\52\4\uffff\1\52\1\uffff\10"+
            "\52\1\u00c6\21\52",
            "\1\u00c7\37\uffff\1\u00c7",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u00c9\37\uffff\1\u00c9",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\u00bf\7\uffff\6\u00bf\24\52\4\uffff\1\52\1\uffff\6\u00bf"+
            "\24\52",
            "\12\52\7\uffff\22\52\1\u00cd\7\52\4\uffff\1\52\1\uffff\22\52"+
            "\1\u00cd\7\52",
            "",
            "\12\52\7\uffff\16\52\1\u00cf\13\52\4\uffff\1\52\1\uffff\16"+
            "\52\1\u00cf\13\52",
            "\1\u00d0\37\uffff\1\u00d0",
            "\1\u00d1\37\uffff\1\u00d1",
            "\1\u00d2\37\uffff\1\u00d2",
            "\1\u00d3\37\uffff\1\u00d3",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u00d5\37\uffff\1\u00d5",
            "\1\u00d6\37\uffff\1\u00d6",
            "\1\u00d7\37\uffff\1\u00d7",
            "\1\u00d8\37\uffff\1\u00d8",
            "\1\u00d9\37\uffff\1\u00d9",
            "\1\u00da\37\uffff\1\u00da",
            "\1\u00db\37\uffff\1\u00db",
            "\1\u00dc\37\uffff\1\u00dc",
            "\1\u00dd\37\uffff\1\u00dd",
            "\1\u00de\37\uffff\1\u00de",
            "\1\u00df\37\uffff\1\u00df",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u00e0\37\uffff\1\u00e0",
            "\1\u00e1\37\uffff\1\u00e1",
            "\1\u00e2\37\uffff\1\u00e2",
            "\12\u00bf\7\uffff\6\u00bf\1\uffff\1\u00e3\30\uffff\6\u00bf"+
            "\1\uffff\1\u00e3",
            "\1\u00e4\37\uffff\1\u00e4",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\1\u00e5\37\uffff\1\u00e5",
            "\1\u00e6\37\uffff\1\u00e6",
            "\1\u00e7\37\uffff\1\u00e7",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u00e9\37\uffff\1\u00e9",
            "\1\u00ea\37\uffff\1\u00ea",
            "\1\u00eb\37\uffff\1\u00eb",
            "\1\u00ec\37\uffff\1\u00ec",
            "\1\u00ed\37\uffff\1\u00ed",
            "",
            "\1\u00ee\37\uffff\1\u00ee",
            "\1\u00ef\37\uffff\1\u00ef",
            "\1\u00f0\37\uffff\1\u00f0",
            "\12\u00bf\7\uffff\6\u00bf\2\uffff\1\u00f1\27\uffff\6\u00bf"+
            "\2\uffff\1\u00f1",
            "\1\u00f2\37\uffff\1\u00f2",
            "\1\u00f3\37\uffff\1\u00f3",
            "\1\u00f4\37\uffff\1\u00f4",
            "\1\u00f5\37\uffff\1\u00f5",
            "\1\u00f6\37\uffff\1\u00f6",
            "\1\u00f7\37\uffff\1\u00f7",
            "\1\u00f9\5\uffff\1\u00f8\31\uffff\1\u00f9\5\uffff\1\u00f8",
            "\1\u00fa\37\uffff\1\u00fa",
            "\1\u00fb\37\uffff\1\u00fb",
            "\1\u00fc\37\uffff\1\u00fc",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\156\1\uffff\12\u00fe\7\uffff\6\155\32\uffff\6\155",
            "\1\u00ff\37\uffff\1\u00ff",
            "\1\u0100\37\uffff\1\u0100",
            "",
            "\1\u0101\37\uffff\1\u0101",
            "\1\u0102\37\uffff\1\u0102",
            "",
            "\12\u0103\7\uffff\6\u0103\32\uffff\6\u0103",
            "\1\u0104",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u0107\37\uffff\1\u0107",
            "\1\u0108\37\uffff\1\u0108",
            "",
            "\1\u0109\37\uffff\1\u0109",
            "\1\u010a\37\uffff\1\u010a",
            "",
            "\1\u010b\37\uffff\1\u010b",
            "",
            "",
            "",
            "\1\u010c\37\uffff\1\u010c",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u010e\37\uffff\1\u010e",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u0110\37\uffff\1\u0110",
            "\1\u0111\37\uffff\1\u0111",
            "",
            "\1\u0112\37\uffff\1\u0112",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u0115\37\uffff\1\u0115",
            "\1\u0116\37\uffff\1\u0116",
            "\1\u0117\37\uffff\1\u0117",
            "\1\u0118\37\uffff\1\u0118",
            "\1\u0119\37\uffff\1\u0119",
            "\1\u011a\37\uffff\1\u011a",
            "\1\u011b\37\uffff\1\u011b",
            "\1\u011c\37\uffff\1\u011c",
            "\1\u011d\37\uffff\1\u011d",
            "\1\u011e\37\uffff\1\u011e",
            "\1\u011f\37\uffff\1\u011f",
            "\1\u0120",
            "\1\u0121\1\uffff\1\u0122\35\uffff\1\u0121\1\uffff\1\u0122",
            "\1\u0123\37\uffff\1\u0123",
            "\1\u0124\37\uffff\1\u0124",
            "\1\u0125\37\uffff\1\u0125",
            "",
            "\1\u0126\37\uffff\1\u0126",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u0129\37\uffff\1\u0129",
            "\1\u012a\37\uffff\1\u012a",
            "\1\u012b\37\uffff\1\u012b",
            "\1\u012c\37\uffff\1\u012c",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u012e\37\uffff\1\u012e",
            "\1\u012f\37\uffff\1\u012f",
            "\12\52\7\uffff\21\52\1\u0131\10\52\4\uffff\1\52\1\uffff\21"+
            "\52\1\u0131\10\52",
            "\1\u0132\37\uffff\1\u0132",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u0134\37\uffff\1\u0134",
            "\1\u0135\37\uffff\1\u0135",
            "\1\u0136\37\uffff\1\u0136",
            "\1\u0137\37\uffff\1\u0137",
            "\1\u0138\37\uffff\1\u0138",
            "\1\u0139\37\uffff\1\u0139",
            "\1\u013a\37\uffff\1\u013a",
            "",
            "\1\156\1\uffff\12\u013b\7\uffff\6\155\32\uffff\6\155",
            "\1\u013c\37\uffff\1\u013c",
            "\1\u013d\37\uffff\1\u013d",
            "\1\u013e\37\uffff\1\u013e",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\u0140\7\uffff\6\u0140\32\uffff\6\u0140",
            "\1\u0141\37\uffff\1\u0141",
            "",
            "",
            "\1\u0142\37\uffff\1\u0142",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u0147\37\uffff\1\u0147",
            "",
            "\1\u0148\37\uffff\1\u0148",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u014b\37\uffff\1\u014b",
            "",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u014d",
            "\1\u014e\37\uffff\1\u014e",
            "\1\u014f\37\uffff\1\u014f",
            "\1\u0150\37\uffff\1\u0150",
            "\12\52\7\uffff\4\52\1\u0152\25\52\4\uffff\1\52\1\uffff\4\52"+
            "\1\u0152\25\52",
            "\1\u0153\37\uffff\1\u0153",
            "\1\u0154\37\uffff\1\u0154",
            "\1\u0155\37\uffff\1\u0155",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u0157\37\uffff\1\u0157",
            "\1\u0158\37\uffff\1\u0158",
            "\1\u0159\37\uffff\1\u0159",
            "\1\u015a\37\uffff\1\u015a",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u015d\37\uffff\1\u015d",
            "",
            "",
            "\1\u015e\37\uffff\1\u015e",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u0161\37\uffff\1\u0161",
            "",
            "\1\u0162\37\uffff\1\u0162",
            "\1\u0163\37\uffff\1\u0163",
            "",
            "\1\u0164\37\uffff\1\u0164",
            "\1\u0165\37\uffff\1\u0165",
            "",
            "\1\u0166\37\uffff\1\u0166",
            "\1\u0167\37\uffff\1\u0167",
            "\1\u0168\37\uffff\1\u0168",
            "\1\u0169\37\uffff\1\u0169",
            "\12\52\7\uffff\22\52\1\u016b\7\52\4\uffff\1\52\1\uffff\22\52"+
            "\1\u016b\7\52",
            "\1\u016c\37\uffff\1\u016c",
            "\1\u016d\37\uffff\1\u016d",
            "\1\156\1\uffff\12\u016e\7\uffff\6\155\32\uffff\6\155",
            "\1\u016f\37\uffff\1\u016f",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\12\u0172\7\uffff\6\u0172\32\uffff\6\u0172",
            "\1\u0173\37\uffff\1\u0173",
            "\1\u0174\37\uffff\1\u0174",
            "",
            "",
            "",
            "",
            "\1\u0175\37\uffff\1\u0175",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\1\u0178\37\uffff\1\u0178",
            "\1\u0179\37\uffff\1\u0179",
            "\1\u017a\37\uffff\1\u017a",
            "\1\u017b\37\uffff\1\u017b",
            "",
            "\1\u017c\37\uffff\1\u017c",
            "\1\u017d\37\uffff\1\u017d",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u0180\37\uffff\1\u0180",
            "\1\u0181\37\uffff\1\u0181",
            "\1\u0182\37\uffff\1\u0182",
            "",
            "",
            "\1\u0183\37\uffff\1\u0183",
            "\1\u0184\37\uffff\1\u0184",
            "",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u0186\37\uffff\1\u0186",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u0188\37\uffff\1\u0188",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u018a\37\uffff\1\u018a",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u018d\37\uffff\1\u018d",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u0190\37\uffff\1\u0190",
            "\1\156\1\uffff\12\u0191\7\uffff\6\155\32\uffff\6\155",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "\12\u0193\7\uffff\6\u0193\32\uffff\6\u0193",
            "\1\u0194\37\uffff\1\u0194",
            "\1\u0195\37\uffff\1\u0195",
            "\1\u0196\37\uffff\1\u0196",
            "",
            "",
            "\1\u0197\37\uffff\1\u0197",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u0199\37\uffff\1\u0199",
            "\1\u019a\37\uffff\1\u019a",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u019c\37\uffff\1\u019c",
            "",
            "",
            "\1\u019d\37\uffff\1\u019d",
            "\1\u019e\37\uffff\1\u019e",
            "\1\u019f\37\uffff\1\u019f",
            "\1\u01a0\37\uffff\1\u01a0",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\1\u01a3\37\uffff\1\u01a3",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "\1\u01a6\37\uffff\1\u01a6",
            "\1\156\1\uffff\12\u01a7\7\uffff\6\155\32\uffff\6\155",
            "",
            "\1\155",
            "\1\u01a8\37\uffff\1\u01a8",
            "\1\u01a9\37\uffff\1\u01a9",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u01aa\37\uffff\1\u01aa",
            "",
            "\1\u01ab\37\uffff\1\u01ab",
            "\1\u01ac\37\uffff\1\u01ac",
            "",
            "\1\u01ad\37\uffff\1\u01ad",
            "\1\u01ae\37\uffff\1\u01ae",
            "\1\u01af\37\uffff\1\u01af",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "\1\u01b3\37\uffff\1\u01b3",
            "\1\155\1\156\1\uffff\12\56",
            "\1\u01b4\37\uffff\1\u01b4",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u01b6\37\uffff\1\u01b6",
            "\1\u01b7\37\uffff\1\u01b7",
            "\1\u01b8\37\uffff\1\u01b8",
            "\1\u01b9\37\uffff\1\u01b9",
            "\1\u01ba\37\uffff\1\u01ba",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u01bd\37\uffff\1\u01bd",
            "",
            "\1\u01be\37\uffff\1\u01be",
            "\1\u01bf\37\uffff\1\u01bf",
            "\1\u01c0\37\uffff\1\u01c0",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u01c2\37\uffff\1\u01c2",
            "",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\1\u01c4\37\uffff\1\u01c4",
            "\1\u01c5\37\uffff\1\u01c5",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | T__124 | T__125 | T__126 | T__127 | T__128 | T__129 | T__130 | K_SELECT | K_FROM | K_WHERE | K_AND | K_KEY | K_INSERT | K_UPDATE | K_WITH | K_LIMIT | K_USING | K_CONSISTENCY | K_LEVEL | K_USE | K_COUNT | K_SET | K_BEGIN | K_APPLY | K_BATCH | K_TRUNCATE | K_DELETE | K_IN | K_CREATE | K_KEYSPACE | K_COLUMNFAMILY | K_INDEX | K_ON | K_TO | K_DROP | K_PRIMARY | K_INTO | K_VALUES | K_TIMESTAMP | K_TTL | K_ALTER | K_ADD | K_TYPE | K_COMPACT | K_STORAGE | K_ORDER | K_BY | K_ASC | K_DESC | K_GRANT | K_GRANTS | K_REVOKE | K_OPTION | K_DESCRIBE | K_FOR | K_FULL_ACCESS | K_NO_ACCESS | K_CLUSTERING | K_ASCII | K_BIGINT | K_BLOB | K_BOOLEAN | K_COUNTER | K_DECIMAL | K_DOUBLE | K_FLOAT | K_INET | K_INT | K_TEXT | K_UUID | K_VARCHAR | K_VARINT | K_TIMEUUID | K_TOKEN | K_WRITETIME | K_MAP | K_LIST | STRING_LITERAL | QUOTED_NAME | INTEGER | QMARK | FLOAT | IDENT | UUID | WS | COMMENT | MULTILINE_COMMENT );";
        }
    }
 

}