// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g 2016-04-26 17:48:06

    package org.apache.cassandra.cql3;

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Collections;
    import java.util.HashMap;
    import java.util.LinkedHashMap;
    import java.util.List;
    import java.util.Map;

    import org.apache.cassandra.cql3.operations.*;
    import org.apache.cassandra.auth.Permission;
    import org.apache.cassandra.cql3.statements.*;
    import org.apache.cassandra.db.marshal.CollectionType;
    import org.apache.cassandra.exceptions.ConfigurationException;
    import org.apache.cassandra.exceptions.InvalidRequestException;
    import org.apache.cassandra.exceptions.SyntaxException;
    import org.apache.cassandra.utils.Pair;
    import org.apache.cassandra.db.ConsistencyLevel;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CqlParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "K_USE", "K_SELECT", "K_COUNT", "K_FROM", "K_USING", "K_CONSISTENCY", "K_LEVEL", "K_WHERE", "K_ORDER", "K_BY", "K_LIMIT", "INTEGER", "K_WRITETIME", "K_TTL", "K_AND", "K_ASC", "K_DESC", "K_INSERT", "K_INTO", "K_VALUES", "K_TIMESTAMP", "K_UPDATE", "K_SET", "K_DELETE", "K_BEGIN", "K_BATCH", "K_APPLY", "K_CREATE", "K_KEYSPACE", "K_WITH", "K_COLUMNFAMILY", "K_PRIMARY", "K_KEY", "K_COMPACT", "K_STORAGE", "K_CLUSTERING", "K_INDEX", "IDENT", "K_ON", "K_ALTER", "K_TYPE", "K_ADD", "K_DROP", "K_TRUNCATE", "K_GRANT", "K_TO", "STRING_LITERAL", "K_OPTION", "K_REVOKE", "K_LIST", "K_GRANTS", "K_FOR", "K_DESCRIBE", "K_FULL_ACCESS", "K_NO_ACCESS", "QUOTED_NAME", "UUID", "FLOAT", "QMARK", "K_TOKEN", "K_IN", "K_ASCII", "K_BIGINT", "K_BLOB", "K_BOOLEAN", "K_COUNTER", "K_DECIMAL", "K_DOUBLE", "K_FLOAT", "K_INET", "K_INT", "K_TEXT", "K_UUID", "K_VARCHAR", "K_VARINT", "K_TIMEUUID", "K_MAP", "S", "E", "L", "C", "T", "F", "R", "O", "M", "W", "H", "A", "N", "D", "K", "Y", "I", "U", "P", "G", "Q", "B", "X", "V", "J", "Z", "DIGIT", "LETTER", "HEX", "WS", "COMMENT", "MULTILINE_COMMENT", "';'", "'('", "')'", "','", "'\\*'", "'['", "']'", "'.'", "'{'", "'}'", "':'", "'='", "'+'", "'-'", "'<'", "'<='", "'>='", "'>'"
    };
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
    public static final int COMMENT=111;
    public static final int K_TRUNCATE=47;
    public static final int K_FULL_ACCESS=57;
    public static final int K_ORDER=12;
    public static final int D=94;
    public static final int E=82;
    public static final int F=86;
    public static final int G=100;
    public static final int K_COUNT=6;
    public static final int K_KEYSPACE=32;
    public static final int K_TYPE=44;
    public static final int A=92;
    public static final int B=102;
    public static final int C=84;
    public static final int L=83;
    public static final int M=89;
    public static final int N=93;
    public static final int O=88;
    public static final int H=91;
    public static final int I=97;
    public static final int J=105;
    public static final int K_UPDATE=25;
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
    public static final int K_BY=13;
    public static final int T__121=121;
    public static final int T__120=120;
    public static final int FLOAT=61;
    public static final int K_VARINT=78;
    public static final int K_FLOAT=72;
    public static final int K_DOUBLE=71;
    public static final int K_SELECT=5;
    public static final int K_LIMIT=14;
    public static final int K_ALTER=43;
    public static final int K_BOOLEAN=68;
    public static final int K_SET=26;
    public static final int K_WHERE=11;
    public static final int QUOTED_NAME=59;
    public static final int K_DESCRIBE=56;
    public static final int MULTILINE_COMMENT=112;
    public static final int K_BLOB=67;
    public static final int HEX=109;
    public static final int K_INTO=22;
    public static final int K_REVOKE=52;
    public static final int K_VARCHAR=77;
    public static final int T__113=113;
    public static final int IDENT=41;
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

    // delegates
    // delegators


        public CqlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public CqlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return CqlParser.tokenNames; }
    public String getGrammarFileName() { return "/home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g"; }


        private List<String> recognitionErrors = new ArrayList<String>();
        private int currentBindMarkerIdx = -1;

        public void displayRecognitionError(String[] tokenNames, RecognitionException e)
        {
            String hdr = getErrorHeader(e);
            String msg = getErrorMessage(e, tokenNames);
            recognitionErrors.add(hdr + " " + msg);
        }

        public void addRecognitionError(String msg)
        {
            recognitionErrors.add(msg);
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

        // used by UPDATE of the counter columns to validate if '-' was supplied by user
        public void validateMinusSupplied(Object op, final Term value, IntStream stream) throws MissingTokenException
        {
            if (op == null && (value.isBindMarker() || Long.parseLong(value.getText()) > 0))
                throw new MissingTokenException(102, stream, value);
        }

        public Map<String, String> convertMap(Map<Term, Term> terms)
        {
            if (terms == null || terms.isEmpty())
                return Collections.<String, String>emptyMap();

            Map<String, String> res = new HashMap<String, String>(terms.size());

            for (Map.Entry<Term, Term> entry : terms.entrySet())
            {
                // Because the parser tries to be smart and recover on error (to
                // allow displaying more than one error I suppose), we have null
                // entries in there. Just skip those, a proper error will be thrown in the end.
                if (entry.getKey() == null || entry.getValue() == null)
                    break;
                res.put(entry.getKey().getText(), entry.getValue().getText());
            }

            return res;
        }



    // $ANTLR start "query"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:147:1: query returns [ParsedStatement stmnt] : st= cqlStatement ( ';' )* EOF ;
    public final ParsedStatement query() throws RecognitionException {
        ParsedStatement stmnt = null;

        ParsedStatement st = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:150:5: (st= cqlStatement ( ';' )* EOF )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:150:7: st= cqlStatement ( ';' )* EOF
            {
            pushFollow(FOLLOW_cqlStatement_in_query72);
            st=cqlStatement();

            state._fsp--;

            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:150:23: ( ';' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==113) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:150:24: ';'
            	    {
            	    match(input,113,FOLLOW_113_in_query75); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match(input,EOF,FOLLOW_EOF_in_query79); 
             stmnt = st; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmnt;
    }
    // $ANTLR end "query"


    // $ANTLR start "cqlStatement"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:153:1: cqlStatement returns [ParsedStatement stmt] : (st1= selectStatement | st2= insertStatement | st3= updateStatement | st4= batchStatement | st5= deleteStatement | st6= useStatement | st7= truncateStatement | st8= createKeyspaceStatement | st9= createColumnFamilyStatement | st10= createIndexStatement | st11= dropKeyspaceStatement | st12= dropColumnFamilyStatement | st13= dropIndexStatement | st14= alterTableStatement | st15= grantStatement | st16= revokeStatement | st17= listGrantsStatement | st18= alterKeyspaceStatement );
    public final ParsedStatement cqlStatement() throws RecognitionException {
        ParsedStatement stmt = null;

        SelectStatement.RawStatement st1 = null;

        UpdateStatement st2 = null;

        UpdateStatement st3 = null;

        BatchStatement st4 = null;

        DeleteStatement st5 = null;

        UseStatement st6 = null;

        TruncateStatement st7 = null;

        CreateKeyspaceStatement st8 = null;

        CreateColumnFamilyStatement.RawStatement st9 = null;

        CreateIndexStatement st10 = null;

        DropKeyspaceStatement st11 = null;

        DropColumnFamilyStatement st12 = null;

        DropIndexStatement st13 = null;

        AlterTableStatement st14 = null;

        GrantStatement st15 = null;

        RevokeStatement st16 = null;

        ListGrantsStatement st17 = null;

        AlterKeyspaceStatement st18 = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:155:5: (st1= selectStatement | st2= insertStatement | st3= updateStatement | st4= batchStatement | st5= deleteStatement | st6= useStatement | st7= truncateStatement | st8= createKeyspaceStatement | st9= createColumnFamilyStatement | st10= createIndexStatement | st11= dropKeyspaceStatement | st12= dropColumnFamilyStatement | st13= dropIndexStatement | st14= alterTableStatement | st15= grantStatement | st16= revokeStatement | st17= listGrantsStatement | st18= alterKeyspaceStatement )
            int alt2=18;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:155:7: st1= selectStatement
                    {
                    pushFollow(FOLLOW_selectStatement_in_cqlStatement113);
                    st1=selectStatement();

                    state._fsp--;

                     stmt = st1; 

                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:156:7: st2= insertStatement
                    {
                    pushFollow(FOLLOW_insertStatement_in_cqlStatement138);
                    st2=insertStatement();

                    state._fsp--;

                     stmt = st2; 

                    }
                    break;
                case 3 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:157:7: st3= updateStatement
                    {
                    pushFollow(FOLLOW_updateStatement_in_cqlStatement163);
                    st3=updateStatement();

                    state._fsp--;

                     stmt = st3; 

                    }
                    break;
                case 4 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:158:7: st4= batchStatement
                    {
                    pushFollow(FOLLOW_batchStatement_in_cqlStatement188);
                    st4=batchStatement();

                    state._fsp--;

                     stmt = st4; 

                    }
                    break;
                case 5 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:159:7: st5= deleteStatement
                    {
                    pushFollow(FOLLOW_deleteStatement_in_cqlStatement214);
                    st5=deleteStatement();

                    state._fsp--;

                     stmt = st5; 

                    }
                    break;
                case 6 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:160:7: st6= useStatement
                    {
                    pushFollow(FOLLOW_useStatement_in_cqlStatement239);
                    st6=useStatement();

                    state._fsp--;

                     stmt = st6; 

                    }
                    break;
                case 7 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:161:7: st7= truncateStatement
                    {
                    pushFollow(FOLLOW_truncateStatement_in_cqlStatement267);
                    st7=truncateStatement();

                    state._fsp--;

                     stmt = st7; 

                    }
                    break;
                case 8 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:162:7: st8= createKeyspaceStatement
                    {
                    pushFollow(FOLLOW_createKeyspaceStatement_in_cqlStatement290);
                    st8=createKeyspaceStatement();

                    state._fsp--;

                     stmt = st8; 

                    }
                    break;
                case 9 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:163:7: st9= createColumnFamilyStatement
                    {
                    pushFollow(FOLLOW_createColumnFamilyStatement_in_cqlStatement307);
                    st9=createColumnFamilyStatement();

                    state._fsp--;

                     stmt = st9; 

                    }
                    break;
                case 10 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:164:7: st10= createIndexStatement
                    {
                    pushFollow(FOLLOW_createIndexStatement_in_cqlStatement319);
                    st10=createIndexStatement();

                    state._fsp--;

                     stmt = st10; 

                    }
                    break;
                case 11 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:165:7: st11= dropKeyspaceStatement
                    {
                    pushFollow(FOLLOW_dropKeyspaceStatement_in_cqlStatement338);
                    st11=dropKeyspaceStatement();

                    state._fsp--;

                     stmt = st11; 

                    }
                    break;
                case 12 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:166:7: st12= dropColumnFamilyStatement
                    {
                    pushFollow(FOLLOW_dropColumnFamilyStatement_in_cqlStatement356);
                    st12=dropColumnFamilyStatement();

                    state._fsp--;

                     stmt = st12; 

                    }
                    break;
                case 13 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:167:7: st13= dropIndexStatement
                    {
                    pushFollow(FOLLOW_dropIndexStatement_in_cqlStatement370);
                    st13=dropIndexStatement();

                    state._fsp--;

                     stmt = st13; 

                    }
                    break;
                case 14 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:168:7: st14= alterTableStatement
                    {
                    pushFollow(FOLLOW_alterTableStatement_in_cqlStatement391);
                    st14=alterTableStatement();

                    state._fsp--;

                     stmt = st14; 

                    }
                    break;
                case 15 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:169:7: st15= grantStatement
                    {
                    pushFollow(FOLLOW_grantStatement_in_cqlStatement411);
                    st15=grantStatement();

                    state._fsp--;

                     stmt = st15; 

                    }
                    break;
                case 16 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:170:7: st16= revokeStatement
                    {
                    pushFollow(FOLLOW_revokeStatement_in_cqlStatement436);
                    st16=revokeStatement();

                    state._fsp--;

                     stmt = st16; 

                    }
                    break;
                case 17 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:171:7: st17= listGrantsStatement
                    {
                    pushFollow(FOLLOW_listGrantsStatement_in_cqlStatement460);
                    st17=listGrantsStatement();

                    state._fsp--;

                     stmt = st17; 

                    }
                    break;
                case 18 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:172:7: st18= alterKeyspaceStatement
                    {
                    pushFollow(FOLLOW_alterKeyspaceStatement_in_cqlStatement480);
                    st18=alterKeyspaceStatement();

                    state._fsp--;

                     stmt = st18; 

                    }
                    break;

            }
             if (stmt != null) stmt.setBoundTerms(currentBindMarkerIdx + 1); 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "cqlStatement"


    // $ANTLR start "useStatement"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:178:1: useStatement returns [UseStatement stmt] : K_USE ks= keyspaceName ;
    public final UseStatement useStatement() throws RecognitionException {
        UseStatement stmt = null;

        String ks = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:179:5: ( K_USE ks= keyspaceName )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:179:7: K_USE ks= keyspaceName
            {
            match(input,K_USE,FOLLOW_K_USE_in_useStatement510); 
            pushFollow(FOLLOW_keyspaceName_in_useStatement514);
            ks=keyspaceName();

            state._fsp--;

             stmt = new UseStatement(ks); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "useStatement"


    // $ANTLR start "selectStatement"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:182:1: selectStatement returns [SelectStatement.RawStatement expr] : K_SELECT (sclause= selectClause | ( K_COUNT '(' sclause= selectCountClause ')' ) ) K_FROM cf= columnFamilyName ( K_USING K_CONSISTENCY K_LEVEL )? ( K_WHERE wclause= whereClause )? ( K_ORDER K_BY orderByClause[orderings] ( ',' orderByClause[orderings] )* )? ( K_LIMIT rows= INTEGER )? ;
    public final SelectStatement.RawStatement selectStatement() throws RecognitionException {
        SelectStatement.RawStatement expr = null;

        Token rows=null;
        Token K_LEVEL1=null;
        List<Selector> sclause = null;

        CFName cf = null;

        List<Relation> wclause = null;



                boolean isCount = false;
                ConsistencyLevel cLevel = null;
                int limit = 10000;
                Map<ColumnIdentifier, Boolean> orderings = new LinkedHashMap<ColumnIdentifier, Boolean>();
            
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:196:5: ( K_SELECT (sclause= selectClause | ( K_COUNT '(' sclause= selectCountClause ')' ) ) K_FROM cf= columnFamilyName ( K_USING K_CONSISTENCY K_LEVEL )? ( K_WHERE wclause= whereClause )? ( K_ORDER K_BY orderByClause[orderings] ( ',' orderByClause[orderings] )* )? ( K_LIMIT rows= INTEGER )? )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:196:7: K_SELECT (sclause= selectClause | ( K_COUNT '(' sclause= selectCountClause ')' ) ) K_FROM cf= columnFamilyName ( K_USING K_CONSISTENCY K_LEVEL )? ( K_WHERE wclause= whereClause )? ( K_ORDER K_BY orderByClause[orderings] ( ',' orderByClause[orderings] )* )? ( K_LIMIT rows= INTEGER )?
            {
            match(input,K_SELECT,FOLLOW_K_SELECT_in_selectStatement548); 
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:196:16: (sclause= selectClause | ( K_COUNT '(' sclause= selectCountClause ')' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=K_CONSISTENCY && LA3_0<=K_LEVEL)||(LA3_0>=K_WRITETIME && LA3_0<=K_TTL)||(LA3_0>=K_VALUES && LA3_0<=K_TIMESTAMP)||(LA3_0>=K_KEY && LA3_0<=K_CLUSTERING)||LA3_0==IDENT||LA3_0==K_TYPE||LA3_0==K_LIST||LA3_0==QUOTED_NAME||(LA3_0>=K_ASCII && LA3_0<=K_MAP)||LA3_0==117) ) {
                alt3=1;
            }
            else if ( (LA3_0==K_COUNT) ) {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==114) ) {
                    alt3=2;
                }
                else if ( (LA3_2==K_FROM||LA3_2==116) ) {
                    alt3=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:196:18: sclause= selectClause
                    {
                    pushFollow(FOLLOW_selectClause_in_selectStatement554);
                    sclause=selectClause();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:196:41: ( K_COUNT '(' sclause= selectCountClause ')' )
                    {
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:196:41: ( K_COUNT '(' sclause= selectCountClause ')' )
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:196:42: K_COUNT '(' sclause= selectCountClause ')'
                    {
                    match(input,K_COUNT,FOLLOW_K_COUNT_in_selectStatement559); 
                    match(input,114,FOLLOW_114_in_selectStatement561); 
                    pushFollow(FOLLOW_selectCountClause_in_selectStatement565);
                    sclause=selectCountClause();

                    state._fsp--;

                    match(input,115,FOLLOW_115_in_selectStatement567); 
                     isCount = true; 

                    }


                    }
                    break;

            }

            match(input,K_FROM,FOLLOW_K_FROM_in_selectStatement580); 
            pushFollow(FOLLOW_columnFamilyName_in_selectStatement584);
            cf=columnFamilyName();

            state._fsp--;

            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:198:7: ( K_USING K_CONSISTENCY K_LEVEL )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==K_USING) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:198:9: K_USING K_CONSISTENCY K_LEVEL
                    {
                    match(input,K_USING,FOLLOW_K_USING_in_selectStatement594); 
                    match(input,K_CONSISTENCY,FOLLOW_K_CONSISTENCY_in_selectStatement596); 
                    K_LEVEL1=(Token)match(input,K_LEVEL,FOLLOW_K_LEVEL_in_selectStatement598); 
                     cLevel = ConsistencyLevel.valueOf((K_LEVEL1!=null?K_LEVEL1.getText():null).toUpperCase()); 

                    }
                    break;

            }

            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:199:7: ( K_WHERE wclause= whereClause )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==K_WHERE) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:199:9: K_WHERE wclause= whereClause
                    {
                    match(input,K_WHERE,FOLLOW_K_WHERE_in_selectStatement613); 
                    pushFollow(FOLLOW_whereClause_in_selectStatement617);
                    wclause=whereClause();

                    state._fsp--;


                    }
                    break;

            }

            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:200:7: ( K_ORDER K_BY orderByClause[orderings] ( ',' orderByClause[orderings] )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==K_ORDER) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:200:9: K_ORDER K_BY orderByClause[orderings] ( ',' orderByClause[orderings] )*
                    {
                    match(input,K_ORDER,FOLLOW_K_ORDER_in_selectStatement630); 
                    match(input,K_BY,FOLLOW_K_BY_in_selectStatement632); 
                    pushFollow(FOLLOW_orderByClause_in_selectStatement634);
                    orderByClause(orderings);

                    state._fsp--;

                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:200:47: ( ',' orderByClause[orderings] )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==116) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:200:49: ',' orderByClause[orderings]
                    	    {
                    	    match(input,116,FOLLOW_116_in_selectStatement639); 
                    	    pushFollow(FOLLOW_orderByClause_in_selectStatement641);
                    	    orderByClause(orderings);

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }

            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:201:7: ( K_LIMIT rows= INTEGER )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==K_LIMIT) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:201:9: K_LIMIT rows= INTEGER
                    {
                    match(input,K_LIMIT,FOLLOW_K_LIMIT_in_selectStatement658); 
                    rows=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_selectStatement662); 
                     limit = Integer.parseInt((rows!=null?rows.getText():null)); 

                    }
                    break;

            }


                      SelectStatement.Parameters params = new SelectStatement.Parameters(cLevel,
                                                                                         limit,
                                                                                         orderings,
                                                                                         isCount);
                      expr = new SelectStatement.RawStatement(cf, params, sclause, wclause);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "selectStatement"


    // $ANTLR start "selectClause"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:211:1: selectClause returns [List<Selector> expr] : (t1= selector ( ',' tN= selector )* | '\\*' );
    public final List<Selector> selectClause() throws RecognitionException {
        List<Selector> expr = null;

        Selector t1 = null;

        Selector tN = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:212:5: (t1= selector ( ',' tN= selector )* | '\\*' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==K_COUNT||(LA10_0>=K_CONSISTENCY && LA10_0<=K_LEVEL)||(LA10_0>=K_WRITETIME && LA10_0<=K_TTL)||(LA10_0>=K_VALUES && LA10_0<=K_TIMESTAMP)||(LA10_0>=K_KEY && LA10_0<=K_CLUSTERING)||LA10_0==IDENT||LA10_0==K_TYPE||LA10_0==K_LIST||LA10_0==QUOTED_NAME||(LA10_0>=K_ASCII && LA10_0<=K_MAP)) ) {
                alt10=1;
            }
            else if ( (LA10_0==117) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:212:7: t1= selector ( ',' tN= selector )*
                    {
                    pushFollow(FOLLOW_selector_in_selectClause698);
                    t1=selector();

                    state._fsp--;

                     expr = new ArrayList<Selector>(); expr.add(t1); 
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:212:73: ( ',' tN= selector )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==116) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:212:74: ',' tN= selector
                    	    {
                    	    match(input,116,FOLLOW_116_in_selectClause703); 
                    	    pushFollow(FOLLOW_selector_in_selectClause707);
                    	    tN=selector();

                    	    state._fsp--;

                    	     expr.add(tN); 

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:213:7: '\\*'
                    {
                    match(input,117,FOLLOW_117_in_selectClause719); 
                     expr = Collections.<Selector>emptyList();

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "selectClause"


    // $ANTLR start "selector"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:216:1: selector returns [Selector s] : (c= cident | K_WRITETIME '(' c= cident ')' | K_TTL '(' c= cident ')' );
    public final Selector selector() throws RecognitionException {
        Selector s = null;

        ColumnIdentifier c = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:217:5: (c= cident | K_WRITETIME '(' c= cident ')' | K_TTL '(' c= cident ')' )
            int alt11=3;
            switch ( input.LA(1) ) {
            case K_COUNT:
            case K_CONSISTENCY:
            case K_LEVEL:
            case K_VALUES:
            case K_TIMESTAMP:
            case K_KEY:
            case K_COMPACT:
            case K_STORAGE:
            case K_CLUSTERING:
            case IDENT:
            case K_TYPE:
            case K_LIST:
            case QUOTED_NAME:
            case K_ASCII:
            case K_BIGINT:
            case K_BLOB:
            case K_BOOLEAN:
            case K_COUNTER:
            case K_DECIMAL:
            case K_DOUBLE:
            case K_FLOAT:
            case K_INET:
            case K_INT:
            case K_TEXT:
            case K_UUID:
            case K_VARCHAR:
            case K_VARINT:
            case K_TIMEUUID:
            case K_MAP:
                {
                alt11=1;
                }
                break;
            case K_WRITETIME:
                {
                int LA11_2 = input.LA(2);

                if ( (LA11_2==114) ) {
                    alt11=2;
                }
                else if ( (LA11_2==K_FROM||LA11_2==116) ) {
                    alt11=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 2, input);

                    throw nvae;
                }
                }
                break;
            case K_TTL:
                {
                int LA11_3 = input.LA(2);

                if ( (LA11_3==114) ) {
                    alt11=3;
                }
                else if ( (LA11_3==K_FROM||LA11_3==116) ) {
                    alt11=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:217:7: c= cident
                    {
                    pushFollow(FOLLOW_cident_in_selector744);
                    c=cident();

                    state._fsp--;

                     s = c; 

                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:218:7: K_WRITETIME '(' c= cident ')'
                    {
                    match(input,K_WRITETIME,FOLLOW_K_WRITETIME_in_selector766); 
                    match(input,114,FOLLOW_114_in_selector768); 
                    pushFollow(FOLLOW_cident_in_selector772);
                    c=cident();

                    state._fsp--;

                    match(input,115,FOLLOW_115_in_selector774); 
                     s = new Selector.WithFunction(c, Selector.Function.WRITE_TIME); 

                    }
                    break;
                case 3 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:219:7: K_TTL '(' c= cident ')'
                    {
                    match(input,K_TTL,FOLLOW_K_TTL_in_selector784); 
                    match(input,114,FOLLOW_114_in_selector786); 
                    pushFollow(FOLLOW_cident_in_selector790);
                    c=cident();

                    state._fsp--;

                    match(input,115,FOLLOW_115_in_selector792); 
                     s = new Selector.WithFunction(c, Selector.Function.TTL); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return s;
    }
    // $ANTLR end "selector"


    // $ANTLR start "selectCountClause"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:222:1: selectCountClause returns [List<Selector> expr] : ( '\\*' | i= INTEGER );
    public final List<Selector> selectCountClause() throws RecognitionException {
        List<Selector> expr = null;

        Token i=null;

        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:223:5: ( '\\*' | i= INTEGER )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==117) ) {
                alt12=1;
            }
            else if ( (LA12_0==INTEGER) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:223:7: '\\*'
                    {
                    match(input,117,FOLLOW_117_in_selectCountClause821); 
                     expr = Collections.<Selector>emptyList();

                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:224:7: i= INTEGER
                    {
                    i=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_selectCountClause843); 
                     if (!i.getText().equals("1")) addRecognitionError("Only COUNT(1) is supported, got COUNT(" + i.getText() + ")"); expr = Collections.<Selector>emptyList();

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "selectCountClause"


    // $ANTLR start "whereClause"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:227:1: whereClause returns [List<Relation> clause] : relation[$clause] ( K_AND relation[$clause] )* ;
    public final List<Relation> whereClause() throws RecognitionException {
        List<Relation> clause = null;

         clause = new ArrayList<Relation>(); 
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:229:5: ( relation[$clause] ( K_AND relation[$clause] )* )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:229:7: relation[$clause] ( K_AND relation[$clause] )*
            {
            pushFollow(FOLLOW_relation_in_whereClause879);
            relation(clause);

            state._fsp--;

            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:229:25: ( K_AND relation[$clause] )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==K_AND) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:229:26: K_AND relation[$clause]
            	    {
            	    match(input,K_AND,FOLLOW_K_AND_in_whereClause883); 
            	    pushFollow(FOLLOW_relation_in_whereClause885);
            	    relation(clause);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return clause;
    }
    // $ANTLR end "whereClause"


    // $ANTLR start "orderByClause"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:232:1: orderByClause[Map<ColumnIdentifier, Boolean> orderings] : c= cident ( K_ASC | K_DESC )? ;
    public final void orderByClause(Map<ColumnIdentifier, Boolean> orderings) throws RecognitionException {
        ColumnIdentifier c = null;



                ColumnIdentifier orderBy = null;
                boolean reversed = false;
            
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:237:5: (c= cident ( K_ASC | K_DESC )? )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:237:7: c= cident ( K_ASC | K_DESC )?
            {
            pushFollow(FOLLOW_cident_in_orderByClause916);
            c=cident();

            state._fsp--;

             orderBy = c; 
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:237:33: ( K_ASC | K_DESC )?
            int alt14=3;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==K_ASC) ) {
                alt14=1;
            }
            else if ( (LA14_0==K_DESC) ) {
                alt14=2;
            }
            switch (alt14) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:237:34: K_ASC
                    {
                    match(input,K_ASC,FOLLOW_K_ASC_in_orderByClause921); 

                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:237:42: K_DESC
                    {
                    match(input,K_DESC,FOLLOW_K_DESC_in_orderByClause925); 
                     reversed = true; 

                    }
                    break;

            }

             orderings.put(c, reversed); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "orderByClause"


    // $ANTLR start "insertStatement"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:240:1: insertStatement returns [UpdateStatement expr] : K_INSERT K_INTO cf= columnFamilyName '(' c1= cident ( ',' cn= cident )+ ')' K_VALUES '(' v1= set_operation ( ',' vn= set_operation )+ ')' ( usingClause[attrs] )? ;
    public final UpdateStatement insertStatement() throws RecognitionException {
        UpdateStatement expr = null;

        CFName cf = null;

        ColumnIdentifier c1 = null;

        ColumnIdentifier cn = null;

        Operation v1 = null;

        Operation vn = null;



                Attributes attrs = new Attributes();
                List<ColumnIdentifier> columnNames  = new ArrayList<ColumnIdentifier>();
                List<Operation> columnOperations = new ArrayList<Operation>();
            
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:253:5: ( K_INSERT K_INTO cf= columnFamilyName '(' c1= cident ( ',' cn= cident )+ ')' K_VALUES '(' v1= set_operation ( ',' vn= set_operation )+ ')' ( usingClause[attrs] )? )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:253:7: K_INSERT K_INTO cf= columnFamilyName '(' c1= cident ( ',' cn= cident )+ ')' K_VALUES '(' v1= set_operation ( ',' vn= set_operation )+ ')' ( usingClause[attrs] )?
            {
            match(input,K_INSERT,FOLLOW_K_INSERT_in_insertStatement963); 
            match(input,K_INTO,FOLLOW_K_INTO_in_insertStatement965); 
            pushFollow(FOLLOW_columnFamilyName_in_insertStatement969);
            cf=columnFamilyName();

            state._fsp--;

            match(input,114,FOLLOW_114_in_insertStatement981); 
            pushFollow(FOLLOW_cident_in_insertStatement985);
            c1=cident();

            state._fsp--;

             columnNames.add(c1); 
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:254:51: ( ',' cn= cident )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==116) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:254:53: ',' cn= cident
            	    {
            	    match(input,116,FOLLOW_116_in_insertStatement992); 
            	    pushFollow(FOLLOW_cident_in_insertStatement996);
            	    cn=cident();

            	    state._fsp--;

            	     columnNames.add(cn); 

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);

            match(input,115,FOLLOW_115_in_insertStatement1003); 
            match(input,K_VALUES,FOLLOW_K_VALUES_in_insertStatement1013); 
            match(input,114,FOLLOW_114_in_insertStatement1025); 
            pushFollow(FOLLOW_set_operation_in_insertStatement1029);
            v1=set_operation();

            state._fsp--;

             columnOperations.add(v1); 
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:256:62: ( ',' vn= set_operation )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==116) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:256:64: ',' vn= set_operation
            	    {
            	    match(input,116,FOLLOW_116_in_insertStatement1035); 
            	    pushFollow(FOLLOW_set_operation_in_insertStatement1039);
            	    vn=set_operation();

            	    state._fsp--;

            	     columnOperations.add(vn); 

            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);

            match(input,115,FOLLOW_115_in_insertStatement1046); 
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:257:9: ( usingClause[attrs] )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==K_USING) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:257:11: usingClause[attrs]
                    {
                    pushFollow(FOLLOW_usingClause_in_insertStatement1058);
                    usingClause(attrs);

                    state._fsp--;


                    }
                    break;

            }


                      expr = new UpdateStatement(cf, attrs, columnNames, columnOperations);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "insertStatement"


    // $ANTLR start "usingClause"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:263:1: usingClause[Attributes attrs] : K_USING usingClauseObjective[attrs] ( ( K_AND )? usingClauseObjective[attrs] )* ;
    public final void usingClause(Attributes attrs) throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:264:5: ( K_USING usingClauseObjective[attrs] ( ( K_AND )? usingClauseObjective[attrs] )* )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:264:7: K_USING usingClauseObjective[attrs] ( ( K_AND )? usingClauseObjective[attrs] )*
            {
            match(input,K_USING,FOLLOW_K_USING_in_usingClause1088); 
            pushFollow(FOLLOW_usingClauseObjective_in_usingClause1090);
            usingClauseObjective(attrs);

            state._fsp--;

            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:264:43: ( ( K_AND )? usingClauseObjective[attrs] )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==K_CONSISTENCY||(LA19_0>=K_TTL && LA19_0<=K_AND)||LA19_0==K_TIMESTAMP) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:264:45: ( K_AND )? usingClauseObjective[attrs]
            	    {
            	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:264:45: ( K_AND )?
            	    int alt18=2;
            	    int LA18_0 = input.LA(1);

            	    if ( (LA18_0==K_AND) ) {
            	        alt18=1;
            	    }
            	    switch (alt18) {
            	        case 1 :
            	            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:264:45: K_AND
            	            {
            	            match(input,K_AND,FOLLOW_K_AND_in_usingClause1095); 

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_usingClauseObjective_in_usingClause1098);
            	    usingClauseObjective(attrs);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "usingClause"


    // $ANTLR start "usingClauseDelete"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:267:1: usingClauseDelete[Attributes attrs] : K_USING usingClauseDeleteObjective[attrs] ( ( K_AND )? usingClauseDeleteObjective[attrs] )* ;
    public final void usingClauseDelete(Attributes attrs) throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:268:5: ( K_USING usingClauseDeleteObjective[attrs] ( ( K_AND )? usingClauseDeleteObjective[attrs] )* )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:268:7: K_USING usingClauseDeleteObjective[attrs] ( ( K_AND )? usingClauseDeleteObjective[attrs] )*
            {
            match(input,K_USING,FOLLOW_K_USING_in_usingClauseDelete1120); 
            pushFollow(FOLLOW_usingClauseDeleteObjective_in_usingClauseDelete1122);
            usingClauseDeleteObjective(attrs);

            state._fsp--;

            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:268:49: ( ( K_AND )? usingClauseDeleteObjective[attrs] )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==K_CONSISTENCY||LA21_0==K_AND||LA21_0==K_TIMESTAMP) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:268:51: ( K_AND )? usingClauseDeleteObjective[attrs]
            	    {
            	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:268:51: ( K_AND )?
            	    int alt20=2;
            	    int LA20_0 = input.LA(1);

            	    if ( (LA20_0==K_AND) ) {
            	        alt20=1;
            	    }
            	    switch (alt20) {
            	        case 1 :
            	            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:268:51: K_AND
            	            {
            	            match(input,K_AND,FOLLOW_K_AND_in_usingClauseDelete1127); 

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_usingClauseDeleteObjective_in_usingClauseDelete1130);
            	    usingClauseDeleteObjective(attrs);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "usingClauseDelete"


    // $ANTLR start "usingClauseDeleteObjective"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:271:1: usingClauseDeleteObjective[Attributes attrs] : ( K_CONSISTENCY K_LEVEL | K_TIMESTAMP ts= INTEGER );
    public final void usingClauseDeleteObjective(Attributes attrs) throws RecognitionException {
        Token ts=null;
        Token K_LEVEL2=null;

        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:272:5: ( K_CONSISTENCY K_LEVEL | K_TIMESTAMP ts= INTEGER )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==K_CONSISTENCY) ) {
                alt22=1;
            }
            else if ( (LA22_0==K_TIMESTAMP) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:272:7: K_CONSISTENCY K_LEVEL
                    {
                    match(input,K_CONSISTENCY,FOLLOW_K_CONSISTENCY_in_usingClauseDeleteObjective1152); 
                    K_LEVEL2=(Token)match(input,K_LEVEL,FOLLOW_K_LEVEL_in_usingClauseDeleteObjective1154); 
                     attrs.cLevel = ConsistencyLevel.valueOf((K_LEVEL2!=null?K_LEVEL2.getText():null).toUpperCase()); 

                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:273:7: K_TIMESTAMP ts= INTEGER
                    {
                    match(input,K_TIMESTAMP,FOLLOW_K_TIMESTAMP_in_usingClauseDeleteObjective1165); 
                    ts=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_usingClauseDeleteObjective1169); 
                     attrs.timestamp = Long.valueOf((ts!=null?ts.getText():null)); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "usingClauseDeleteObjective"


    // $ANTLR start "usingClauseObjective"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:276:1: usingClauseObjective[Attributes attrs] : ( usingClauseDeleteObjective[attrs] | K_TTL t= INTEGER );
    public final void usingClauseObjective(Attributes attrs) throws RecognitionException {
        Token t=null;

        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:277:5: ( usingClauseDeleteObjective[attrs] | K_TTL t= INTEGER )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==K_CONSISTENCY||LA23_0==K_TIMESTAMP) ) {
                alt23=1;
            }
            else if ( (LA23_0==K_TTL) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:277:7: usingClauseDeleteObjective[attrs]
                    {
                    pushFollow(FOLLOW_usingClauseDeleteObjective_in_usingClauseObjective1189);
                    usingClauseDeleteObjective(attrs);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:278:7: K_TTL t= INTEGER
                    {
                    match(input,K_TTL,FOLLOW_K_TTL_in_usingClauseObjective1198); 
                    t=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_usingClauseObjective1202); 
                     attrs.timeToLive = Integer.valueOf((t!=null?t.getText():null)); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "usingClauseObjective"


    // $ANTLR start "updateStatement"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:281:1: updateStatement returns [UpdateStatement expr] : K_UPDATE cf= columnFamilyName ( usingClause[attrs] )? K_SET termPairWithOperation[columns] ( ',' termPairWithOperation[columns] )* K_WHERE wclause= whereClause ;
    public final UpdateStatement updateStatement() throws RecognitionException {
        UpdateStatement expr = null;

        CFName cf = null;

        List<Relation> wclause = null;



                Attributes attrs = new Attributes();
                List<Pair<ColumnIdentifier, Operation>> columns = new ArrayList<Pair<ColumnIdentifier, Operation>>();
            
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:292:5: ( K_UPDATE cf= columnFamilyName ( usingClause[attrs] )? K_SET termPairWithOperation[columns] ( ',' termPairWithOperation[columns] )* K_WHERE wclause= whereClause )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:292:7: K_UPDATE cf= columnFamilyName ( usingClause[attrs] )? K_SET termPairWithOperation[columns] ( ',' termPairWithOperation[columns] )* K_WHERE wclause= whereClause
            {
            match(input,K_UPDATE,FOLLOW_K_UPDATE_in_updateStatement1236); 
            pushFollow(FOLLOW_columnFamilyName_in_updateStatement1240);
            cf=columnFamilyName();

            state._fsp--;

            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:293:7: ( usingClause[attrs] )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==K_USING) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:293:9: usingClause[attrs]
                    {
                    pushFollow(FOLLOW_usingClause_in_updateStatement1250);
                    usingClause(attrs);

                    state._fsp--;


                    }
                    break;

            }

            match(input,K_SET,FOLLOW_K_SET_in_updateStatement1262); 
            pushFollow(FOLLOW_termPairWithOperation_in_updateStatement1264);
            termPairWithOperation(columns);

            state._fsp--;

            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:294:44: ( ',' termPairWithOperation[columns] )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==116) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:294:45: ',' termPairWithOperation[columns]
            	    {
            	    match(input,116,FOLLOW_116_in_updateStatement1268); 
            	    pushFollow(FOLLOW_termPairWithOperation_in_updateStatement1270);
            	    termPairWithOperation(columns);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            match(input,K_WHERE,FOLLOW_K_WHERE_in_updateStatement1281); 
            pushFollow(FOLLOW_whereClause_in_updateStatement1285);
            wclause=whereClause();

            state._fsp--;


                      return new UpdateStatement(cf, columns, wclause, attrs);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "updateStatement"


    // $ANTLR start "deleteStatement"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:301:1: deleteStatement returns [DeleteStatement expr] : K_DELETE (ids= deleteSelection )? K_FROM cf= columnFamilyName ( usingClauseDelete[attrs] )? K_WHERE wclause= whereClause ;
    public final DeleteStatement deleteStatement() throws RecognitionException {
        DeleteStatement expr = null;

        List<Selector> ids = null;

        CFName cf = null;

        List<Relation> wclause = null;



                Attributes attrs = new Attributes();
                List<Selector> columnsList = Collections.emptyList();
            
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:312:5: ( K_DELETE (ids= deleteSelection )? K_FROM cf= columnFamilyName ( usingClauseDelete[attrs] )? K_WHERE wclause= whereClause )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:312:7: K_DELETE (ids= deleteSelection )? K_FROM cf= columnFamilyName ( usingClauseDelete[attrs] )? K_WHERE wclause= whereClause
            {
            match(input,K_DELETE,FOLLOW_K_DELETE_in_deleteStatement1325); 
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:312:16: (ids= deleteSelection )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==K_COUNT||(LA26_0>=K_CONSISTENCY && LA26_0<=K_LEVEL)||(LA26_0>=K_WRITETIME && LA26_0<=K_TTL)||(LA26_0>=K_VALUES && LA26_0<=K_TIMESTAMP)||(LA26_0>=K_KEY && LA26_0<=K_CLUSTERING)||LA26_0==IDENT||LA26_0==K_TYPE||LA26_0==K_LIST||LA26_0==QUOTED_NAME||(LA26_0>=K_ASCII && LA26_0<=K_MAP)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:312:18: ids= deleteSelection
                    {
                    pushFollow(FOLLOW_deleteSelection_in_deleteStatement1331);
                    ids=deleteSelection();

                    state._fsp--;

                     columnsList = ids; 

                    }
                    break;

            }

            match(input,K_FROM,FOLLOW_K_FROM_in_deleteStatement1344); 
            pushFollow(FOLLOW_columnFamilyName_in_deleteStatement1348);
            cf=columnFamilyName();

            state._fsp--;

            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:314:7: ( usingClauseDelete[attrs] )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==K_USING) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:314:9: usingClauseDelete[attrs]
                    {
                    pushFollow(FOLLOW_usingClauseDelete_in_deleteStatement1358);
                    usingClauseDelete(attrs);

                    state._fsp--;


                    }
                    break;

            }

            match(input,K_WHERE,FOLLOW_K_WHERE_in_deleteStatement1370); 
            pushFollow(FOLLOW_whereClause_in_deleteStatement1374);
            wclause=whereClause();

            state._fsp--;


                      return new DeleteStatement(cf, columnsList, wclause, attrs);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "deleteStatement"


    // $ANTLR start "deleteSelection"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:321:1: deleteSelection returns [List<Selector> expr] : t1= deleteSelector ( ',' tN= deleteSelector )* ;
    public final List<Selector> deleteSelection() throws RecognitionException {
        List<Selector> expr = null;

        Selector t1 = null;

        Selector tN = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:322:5: (t1= deleteSelector ( ',' tN= deleteSelector )* )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:322:7: t1= deleteSelector ( ',' tN= deleteSelector )*
            {
            pushFollow(FOLLOW_deleteSelector_in_deleteSelection1405);
            t1=deleteSelector();

            state._fsp--;

             expr = new ArrayList<Selector>(); expr.add(t1); 
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:322:79: ( ',' tN= deleteSelector )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==116) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:322:80: ',' tN= deleteSelector
            	    {
            	    match(input,116,FOLLOW_116_in_deleteSelection1410); 
            	    pushFollow(FOLLOW_deleteSelector_in_deleteSelection1414);
            	    tN=deleteSelector();

            	    state._fsp--;

            	     expr.add(tN); 

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "deleteSelection"


    // $ANTLR start "deleteSelector"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:325:1: deleteSelector returns [Selector s] : (c= cident | c= cident '[' t= term ']' );
    public final Selector deleteSelector() throws RecognitionException {
        Selector s = null;

        ColumnIdentifier c = null;

        Term t = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:326:5: (c= cident | c= cident '[' t= term ']' )
            int alt29=2;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:326:7: c= cident
                    {
                    pushFollow(FOLLOW_cident_in_deleteSelector1441);
                    c=cident();

                    state._fsp--;

                     s = c; 

                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:327:7: c= cident '[' t= term ']'
                    {
                    pushFollow(FOLLOW_cident_in_deleteSelector1468);
                    c=cident();

                    state._fsp--;

                    match(input,118,FOLLOW_118_in_deleteSelector1470); 
                    pushFollow(FOLLOW_term_in_deleteSelector1474);
                    t=term();

                    state._fsp--;

                    match(input,119,FOLLOW_119_in_deleteSelector1476); 
                     s = new Selector.WithKey(c, t); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return s;
    }
    // $ANTLR end "deleteSelector"


    // $ANTLR start "batchStatement"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:330:1: batchStatement returns [BatchStatement expr] : K_BEGIN K_BATCH ( usingClause[attrs] )? s1= batchStatementObjective ( ';' )? (sN= batchStatementObjective ( ';' )? )* K_APPLY K_BATCH ;
    public final BatchStatement batchStatement() throws RecognitionException {
        BatchStatement expr = null;

        ModificationStatement s1 = null;

        ModificationStatement sN = null;



                Attributes attrs = new Attributes();
                List<ModificationStatement> statements = new ArrayList<ModificationStatement>();
            
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:359:5: ( K_BEGIN K_BATCH ( usingClause[attrs] )? s1= batchStatementObjective ( ';' )? (sN= batchStatementObjective ( ';' )? )* K_APPLY K_BATCH )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:359:7: K_BEGIN K_BATCH ( usingClause[attrs] )? s1= batchStatementObjective ( ';' )? (sN= batchStatementObjective ( ';' )? )* K_APPLY K_BATCH
            {
            match(input,K_BEGIN,FOLLOW_K_BEGIN_in_batchStatement1510); 
            match(input,K_BATCH,FOLLOW_K_BATCH_in_batchStatement1512); 
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:359:23: ( usingClause[attrs] )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==K_USING) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:359:25: usingClause[attrs]
                    {
                    pushFollow(FOLLOW_usingClause_in_batchStatement1516);
                    usingClause(attrs);

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_batchStatementObjective_in_batchStatement1534);
            s1=batchStatementObjective();

            state._fsp--;

            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:360:38: ( ';' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==113) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:360:38: ';'
                    {
                    match(input,113,FOLLOW_113_in_batchStatement1536); 

                    }
                    break;

            }

             statements.add(s1); 
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:360:67: (sN= batchStatementObjective ( ';' )? )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==K_INSERT||LA33_0==K_UPDATE||LA33_0==K_DELETE) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:360:69: sN= batchStatementObjective ( ';' )?
            	    {
            	    pushFollow(FOLLOW_batchStatementObjective_in_batchStatement1545);
            	    sN=batchStatementObjective();

            	    state._fsp--;

            	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:360:96: ( ';' )?
            	    int alt32=2;
            	    int LA32_0 = input.LA(1);

            	    if ( (LA32_0==113) ) {
            	        alt32=1;
            	    }
            	    switch (alt32) {
            	        case 1 :
            	            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:360:96: ';'
            	            {
            	            match(input,113,FOLLOW_113_in_batchStatement1547); 

            	            }
            	            break;

            	    }

            	     statements.add(sN); 

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            match(input,K_APPLY,FOLLOW_K_APPLY_in_batchStatement1561); 
            match(input,K_BATCH,FOLLOW_K_BATCH_in_batchStatement1563); 

                      return new BatchStatement(statements, attrs);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "batchStatement"


    // $ANTLR start "batchStatementObjective"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:367:1: batchStatementObjective returns [ModificationStatement statement] : (i= insertStatement | u= updateStatement | d= deleteStatement );
    public final ModificationStatement batchStatementObjective() throws RecognitionException {
        ModificationStatement statement = null;

        UpdateStatement i = null;

        UpdateStatement u = null;

        DeleteStatement d = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:368:5: (i= insertStatement | u= updateStatement | d= deleteStatement )
            int alt34=3;
            switch ( input.LA(1) ) {
            case K_INSERT:
                {
                alt34=1;
                }
                break;
            case K_UPDATE:
                {
                alt34=2;
                }
                break;
            case K_DELETE:
                {
                alt34=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:368:7: i= insertStatement
                    {
                    pushFollow(FOLLOW_insertStatement_in_batchStatementObjective1594);
                    i=insertStatement();

                    state._fsp--;

                     statement = i; 

                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:369:7: u= updateStatement
                    {
                    pushFollow(FOLLOW_updateStatement_in_batchStatementObjective1607);
                    u=updateStatement();

                    state._fsp--;

                     statement = u; 

                    }
                    break;
                case 3 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:370:7: d= deleteStatement
                    {
                    pushFollow(FOLLOW_deleteStatement_in_batchStatementObjective1620);
                    d=deleteStatement();

                    state._fsp--;

                     statement = d; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return statement;
    }
    // $ANTLR end "batchStatementObjective"


    // $ANTLR start "createKeyspaceStatement"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:373:1: createKeyspaceStatement returns [CreateKeyspaceStatement expr] : K_CREATE K_KEYSPACE ks= keyspaceName K_WITH properties[attrs] ;
    public final CreateKeyspaceStatement createKeyspaceStatement() throws RecognitionException {
        CreateKeyspaceStatement expr = null;

        String ks = null;


         KSPropDefs attrs = new KSPropDefs(); 
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:378:5: ( K_CREATE K_KEYSPACE ks= keyspaceName K_WITH properties[attrs] )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:378:7: K_CREATE K_KEYSPACE ks= keyspaceName K_WITH properties[attrs]
            {
            match(input,K_CREATE,FOLLOW_K_CREATE_in_createKeyspaceStatement1655); 
            match(input,K_KEYSPACE,FOLLOW_K_KEYSPACE_in_createKeyspaceStatement1657); 
            pushFollow(FOLLOW_keyspaceName_in_createKeyspaceStatement1661);
            ks=keyspaceName();

            state._fsp--;

            match(input,K_WITH,FOLLOW_K_WITH_in_createKeyspaceStatement1669); 
            pushFollow(FOLLOW_properties_in_createKeyspaceStatement1671);
            properties(attrs);

            state._fsp--;

             expr = new CreateKeyspaceStatement(ks, attrs); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "createKeyspaceStatement"


    // $ANTLR start "createColumnFamilyStatement"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:382:1: createColumnFamilyStatement returns [CreateColumnFamilyStatement.RawStatement expr] : K_CREATE K_COLUMNFAMILY cf= columnFamilyName cfamDefinition[expr] ;
    public final CreateColumnFamilyStatement.RawStatement createColumnFamilyStatement() throws RecognitionException {
        CreateColumnFamilyStatement.RawStatement expr = null;

        CFName cf = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:390:5: ( K_CREATE K_COLUMNFAMILY cf= columnFamilyName cfamDefinition[expr] )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:390:7: K_CREATE K_COLUMNFAMILY cf= columnFamilyName cfamDefinition[expr]
            {
            match(input,K_CREATE,FOLLOW_K_CREATE_in_createColumnFamilyStatement1697); 
            match(input,K_COLUMNFAMILY,FOLLOW_K_COLUMNFAMILY_in_createColumnFamilyStatement1699); 
            pushFollow(FOLLOW_columnFamilyName_in_createColumnFamilyStatement1703);
            cf=columnFamilyName();

            state._fsp--;

             expr = new CreateColumnFamilyStatement.RawStatement(cf); 
            pushFollow(FOLLOW_cfamDefinition_in_createColumnFamilyStatement1713);
            cfamDefinition(expr);

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "createColumnFamilyStatement"


    // $ANTLR start "cfamDefinition"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:394:1: cfamDefinition[CreateColumnFamilyStatement.RawStatement expr] : '(' cfamColumns[expr] ( ',' ( cfamColumns[expr] )? )* ')' ( K_WITH cfamProperty[expr] ( K_AND cfamProperty[expr] )* )? ;
    public final void cfamDefinition(CreateColumnFamilyStatement.RawStatement expr) throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:395:5: ( '(' cfamColumns[expr] ( ',' ( cfamColumns[expr] )? )* ')' ( K_WITH cfamProperty[expr] ( K_AND cfamProperty[expr] )* )? )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:395:7: '(' cfamColumns[expr] ( ',' ( cfamColumns[expr] )? )* ')' ( K_WITH cfamProperty[expr] ( K_AND cfamProperty[expr] )* )?
            {
            match(input,114,FOLLOW_114_in_cfamDefinition1732); 
            pushFollow(FOLLOW_cfamColumns_in_cfamDefinition1734);
            cfamColumns(expr);

            state._fsp--;

            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:395:29: ( ',' ( cfamColumns[expr] )? )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==116) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:395:31: ',' ( cfamColumns[expr] )?
            	    {
            	    match(input,116,FOLLOW_116_in_cfamDefinition1739); 
            	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:395:35: ( cfamColumns[expr] )?
            	    int alt35=2;
            	    int LA35_0 = input.LA(1);

            	    if ( (LA35_0==K_COUNT||(LA35_0>=K_CONSISTENCY && LA35_0<=K_LEVEL)||(LA35_0>=K_WRITETIME && LA35_0<=K_TTL)||(LA35_0>=K_VALUES && LA35_0<=K_TIMESTAMP)||(LA35_0>=K_PRIMARY && LA35_0<=K_CLUSTERING)||LA35_0==IDENT||LA35_0==K_TYPE||LA35_0==K_LIST||LA35_0==QUOTED_NAME||(LA35_0>=K_ASCII && LA35_0<=K_MAP)) ) {
            	        alt35=1;
            	    }
            	    switch (alt35) {
            	        case 1 :
            	            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:395:35: cfamColumns[expr]
            	            {
            	            pushFollow(FOLLOW_cfamColumns_in_cfamDefinition1741);
            	            cfamColumns(expr);

            	            state._fsp--;


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            match(input,115,FOLLOW_115_in_cfamDefinition1748); 
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:396:7: ( K_WITH cfamProperty[expr] ( K_AND cfamProperty[expr] )* )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==K_WITH) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:396:9: K_WITH cfamProperty[expr] ( K_AND cfamProperty[expr] )*
                    {
                    match(input,K_WITH,FOLLOW_K_WITH_in_cfamDefinition1758); 
                    pushFollow(FOLLOW_cfamProperty_in_cfamDefinition1760);
                    cfamProperty(expr);

                    state._fsp--;

                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:396:35: ( K_AND cfamProperty[expr] )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==K_AND) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:396:37: K_AND cfamProperty[expr]
                    	    {
                    	    match(input,K_AND,FOLLOW_K_AND_in_cfamDefinition1765); 
                    	    pushFollow(FOLLOW_cfamProperty_in_cfamDefinition1767);
                    	    cfamProperty(expr);

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop37;
                        }
                    } while (true);


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "cfamDefinition"


    // $ANTLR start "cfamColumns"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:399:1: cfamColumns[CreateColumnFamilyStatement.RawStatement expr] : (k= cident v= comparatorType ( K_PRIMARY K_KEY )? | K_PRIMARY K_KEY '(' pkDef[expr] ( ',' c= cident )* ')' );
    public final void cfamColumns(CreateColumnFamilyStatement.RawStatement expr) throws RecognitionException {
        ColumnIdentifier k = null;

        ParsedType v = null;

        ColumnIdentifier c = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:400:5: (k= cident v= comparatorType ( K_PRIMARY K_KEY )? | K_PRIMARY K_KEY '(' pkDef[expr] ( ',' c= cident )* ')' )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==K_COUNT||(LA41_0>=K_CONSISTENCY && LA41_0<=K_LEVEL)||(LA41_0>=K_WRITETIME && LA41_0<=K_TTL)||(LA41_0>=K_VALUES && LA41_0<=K_TIMESTAMP)||(LA41_0>=K_KEY && LA41_0<=K_CLUSTERING)||LA41_0==IDENT||LA41_0==K_TYPE||LA41_0==K_LIST||LA41_0==QUOTED_NAME||(LA41_0>=K_ASCII && LA41_0<=K_MAP)) ) {
                alt41=1;
            }
            else if ( (LA41_0==K_PRIMARY) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:400:7: k= cident v= comparatorType ( K_PRIMARY K_KEY )?
                    {
                    pushFollow(FOLLOW_cident_in_cfamColumns1793);
                    k=cident();

                    state._fsp--;

                    pushFollow(FOLLOW_comparatorType_in_cfamColumns1797);
                    v=comparatorType();

                    state._fsp--;

                     expr.addDefinition(k, v); 
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:400:64: ( K_PRIMARY K_KEY )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==K_PRIMARY) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:400:65: K_PRIMARY K_KEY
                            {
                            match(input,K_PRIMARY,FOLLOW_K_PRIMARY_in_cfamColumns1802); 
                            match(input,K_KEY,FOLLOW_K_KEY_in_cfamColumns1804); 
                             expr.addKeyAliases(Collections.singletonList(k)); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:401:7: K_PRIMARY K_KEY '(' pkDef[expr] ( ',' c= cident )* ')'
                    {
                    match(input,K_PRIMARY,FOLLOW_K_PRIMARY_in_cfamColumns1816); 
                    match(input,K_KEY,FOLLOW_K_KEY_in_cfamColumns1818); 
                    match(input,114,FOLLOW_114_in_cfamColumns1820); 
                    pushFollow(FOLLOW_pkDef_in_cfamColumns1822);
                    pkDef(expr);

                    state._fsp--;

                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:401:39: ( ',' c= cident )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==116) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:401:40: ',' c= cident
                    	    {
                    	    match(input,116,FOLLOW_116_in_cfamColumns1826); 
                    	    pushFollow(FOLLOW_cident_in_cfamColumns1830);
                    	    c=cident();

                    	    state._fsp--;

                    	     expr.addColumnAlias(c); 

                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);

                    match(input,115,FOLLOW_115_in_cfamColumns1837); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "cfamColumns"


    // $ANTLR start "pkDef"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:404:1: pkDef[CreateColumnFamilyStatement.RawStatement expr] : (k= cident | '(' k1= cident ( ',' kn= cident )* ')' );
    public final void pkDef(CreateColumnFamilyStatement.RawStatement expr) throws RecognitionException {
        ColumnIdentifier k = null;

        ColumnIdentifier k1 = null;

        ColumnIdentifier kn = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:405:5: (k= cident | '(' k1= cident ( ',' kn= cident )* ')' )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==K_COUNT||(LA43_0>=K_CONSISTENCY && LA43_0<=K_LEVEL)||(LA43_0>=K_WRITETIME && LA43_0<=K_TTL)||(LA43_0>=K_VALUES && LA43_0<=K_TIMESTAMP)||(LA43_0>=K_KEY && LA43_0<=K_CLUSTERING)||LA43_0==IDENT||LA43_0==K_TYPE||LA43_0==K_LIST||LA43_0==QUOTED_NAME||(LA43_0>=K_ASCII && LA43_0<=K_MAP)) ) {
                alt43=1;
            }
            else if ( (LA43_0==114) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:405:7: k= cident
                    {
                    pushFollow(FOLLOW_cident_in_pkDef1857);
                    k=cident();

                    state._fsp--;

                     expr.addKeyAliases(Collections.singletonList(k)); 

                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:406:7: '(' k1= cident ( ',' kn= cident )* ')'
                    {
                    match(input,114,FOLLOW_114_in_pkDef1867); 
                     List<ColumnIdentifier> l = new ArrayList<ColumnIdentifier>(); 
                    pushFollow(FOLLOW_cident_in_pkDef1873);
                    k1=cident();

                    state._fsp--;

                     l.add(k1); 
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:406:102: ( ',' kn= cident )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==116) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:406:104: ',' kn= cident
                    	    {
                    	    match(input,116,FOLLOW_116_in_pkDef1879); 
                    	    pushFollow(FOLLOW_cident_in_pkDef1883);
                    	    kn=cident();

                    	    state._fsp--;

                    	     l.add(kn); 

                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);

                    match(input,115,FOLLOW_115_in_pkDef1890); 
                     expr.addKeyAliases(l); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "pkDef"


    // $ANTLR start "cfamProperty"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:409:1: cfamProperty[CreateColumnFamilyStatement.RawStatement expr] : ( property[expr.properties] | K_COMPACT K_STORAGE | K_CLUSTERING K_ORDER K_BY '(' cfamOrdering[expr] ( ',' cfamOrdering[expr] )* ')' );
    public final void cfamProperty(CreateColumnFamilyStatement.RawStatement expr) throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:410:5: ( property[expr.properties] | K_COMPACT K_STORAGE | K_CLUSTERING K_ORDER K_BY '(' cfamOrdering[expr] ( ',' cfamOrdering[expr] )* ')' )
            int alt45=3;
            switch ( input.LA(1) ) {
            case K_COUNT:
            case K_CONSISTENCY:
            case K_LEVEL:
            case K_WRITETIME:
            case K_TTL:
            case K_VALUES:
            case K_TIMESTAMP:
            case K_KEY:
            case K_STORAGE:
            case IDENT:
            case K_TYPE:
            case K_LIST:
            case QUOTED_NAME:
            case K_ASCII:
            case K_BIGINT:
            case K_BLOB:
            case K_BOOLEAN:
            case K_COUNTER:
            case K_DECIMAL:
            case K_DOUBLE:
            case K_FLOAT:
            case K_INET:
            case K_INT:
            case K_TEXT:
            case K_UUID:
            case K_VARCHAR:
            case K_VARINT:
            case K_TIMEUUID:
            case K_MAP:
                {
                alt45=1;
                }
                break;
            case K_COMPACT:
                {
                int LA45_2 = input.LA(2);

                if ( (LA45_2==K_STORAGE) ) {
                    alt45=2;
                }
                else if ( (LA45_2==124) ) {
                    alt45=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 2, input);

                    throw nvae;
                }
                }
                break;
            case K_CLUSTERING:
                {
                int LA45_3 = input.LA(2);

                if ( (LA45_3==K_ORDER) ) {
                    alt45=3;
                }
                else if ( (LA45_3==124) ) {
                    alt45=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:410:7: property[expr.properties]
                    {
                    pushFollow(FOLLOW_property_in_cfamProperty1910);
                    property(expr.properties);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:411:7: K_COMPACT K_STORAGE
                    {
                    match(input,K_COMPACT,FOLLOW_K_COMPACT_in_cfamProperty1919); 
                    match(input,K_STORAGE,FOLLOW_K_STORAGE_in_cfamProperty1921); 
                     expr.setCompactStorage(); 

                    }
                    break;
                case 3 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:412:7: K_CLUSTERING K_ORDER K_BY '(' cfamOrdering[expr] ( ',' cfamOrdering[expr] )* ')'
                    {
                    match(input,K_CLUSTERING,FOLLOW_K_CLUSTERING_in_cfamProperty1931); 
                    match(input,K_ORDER,FOLLOW_K_ORDER_in_cfamProperty1933); 
                    match(input,K_BY,FOLLOW_K_BY_in_cfamProperty1935); 
                    match(input,114,FOLLOW_114_in_cfamProperty1937); 
                    pushFollow(FOLLOW_cfamOrdering_in_cfamProperty1939);
                    cfamOrdering(expr);

                    state._fsp--;

                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:412:56: ( ',' cfamOrdering[expr] )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==116) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:412:57: ',' cfamOrdering[expr]
                    	    {
                    	    match(input,116,FOLLOW_116_in_cfamProperty1943); 
                    	    pushFollow(FOLLOW_cfamOrdering_in_cfamProperty1945);
                    	    cfamOrdering(expr);

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop44;
                        }
                    } while (true);

                    match(input,115,FOLLOW_115_in_cfamProperty1950); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "cfamProperty"


    // $ANTLR start "cfamOrdering"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:415:1: cfamOrdering[CreateColumnFamilyStatement.RawStatement expr] : k= cident ( K_ASC | K_DESC ) ;
    public final void cfamOrdering(CreateColumnFamilyStatement.RawStatement expr) throws RecognitionException {
        ColumnIdentifier k = null;


         boolean reversed=false; 
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:417:5: (k= cident ( K_ASC | K_DESC ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:417:7: k= cident ( K_ASC | K_DESC )
            {
            pushFollow(FOLLOW_cident_in_cfamOrdering1978);
            k=cident();

            state._fsp--;

            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:417:16: ( K_ASC | K_DESC )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==K_ASC) ) {
                alt46=1;
            }
            else if ( (LA46_0==K_DESC) ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:417:17: K_ASC
                    {
                    match(input,K_ASC,FOLLOW_K_ASC_in_cfamOrdering1981); 

                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:417:25: K_DESC
                    {
                    match(input,K_DESC,FOLLOW_K_DESC_in_cfamOrdering1985); 
                     reversed=true;

                    }
                    break;

            }

             expr.setOrdering(k, reversed); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "cfamOrdering"


    // $ANTLR start "createIndexStatement"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:420:1: createIndexStatement returns [CreateIndexStatement expr] : K_CREATE K_INDEX (idxName= IDENT )? K_ON cf= columnFamilyName '(' id= cident ')' ;
    public final CreateIndexStatement createIndexStatement() throws RecognitionException {
        CreateIndexStatement expr = null;

        Token idxName=null;
        CFName cf = null;

        ColumnIdentifier id = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:424:5: ( K_CREATE K_INDEX (idxName= IDENT )? K_ON cf= columnFamilyName '(' id= cident ')' )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:424:7: K_CREATE K_INDEX (idxName= IDENT )? K_ON cf= columnFamilyName '(' id= cident ')'
            {
            match(input,K_CREATE,FOLLOW_K_CREATE_in_createIndexStatement2014); 
            match(input,K_INDEX,FOLLOW_K_INDEX_in_createIndexStatement2016); 
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:424:24: (idxName= IDENT )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==IDENT) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:424:25: idxName= IDENT
                    {
                    idxName=(Token)match(input,IDENT,FOLLOW_IDENT_in_createIndexStatement2021); 

                    }
                    break;

            }

            match(input,K_ON,FOLLOW_K_ON_in_createIndexStatement2025); 
            pushFollow(FOLLOW_columnFamilyName_in_createIndexStatement2029);
            cf=columnFamilyName();

            state._fsp--;

            match(input,114,FOLLOW_114_in_createIndexStatement2031); 
            pushFollow(FOLLOW_cident_in_createIndexStatement2035);
            id=cident();

            state._fsp--;

            match(input,115,FOLLOW_115_in_createIndexStatement2037); 
             expr = new CreateIndexStatement(cf, (idxName!=null?idxName.getText():null), id); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "createIndexStatement"


    // $ANTLR start "alterKeyspaceStatement"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:428:1: alterKeyspaceStatement returns [AlterKeyspaceStatement expr] : K_ALTER K_KEYSPACE ks= keyspaceName K_WITH properties[attrs] ;
    public final AlterKeyspaceStatement alterKeyspaceStatement() throws RecognitionException {
        AlterKeyspaceStatement expr = null;

        String ks = null;


         KSPropDefs attrs = new KSPropDefs(); 
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:433:5: ( K_ALTER K_KEYSPACE ks= keyspaceName K_WITH properties[attrs] )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:433:7: K_ALTER K_KEYSPACE ks= keyspaceName K_WITH properties[attrs]
            {
            match(input,K_ALTER,FOLLOW_K_ALTER_in_alterKeyspaceStatement2077); 
            match(input,K_KEYSPACE,FOLLOW_K_KEYSPACE_in_alterKeyspaceStatement2079); 
            pushFollow(FOLLOW_keyspaceName_in_alterKeyspaceStatement2083);
            ks=keyspaceName();

            state._fsp--;

            match(input,K_WITH,FOLLOW_K_WITH_in_alterKeyspaceStatement2093); 
            pushFollow(FOLLOW_properties_in_alterKeyspaceStatement2095);
            properties(attrs);

            state._fsp--;

             expr = new AlterKeyspaceStatement(ks, attrs); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "alterKeyspaceStatement"


    // $ANTLR start "alterTableStatement"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:438:1: alterTableStatement returns [AlterTableStatement expr] : K_ALTER K_COLUMNFAMILY cf= columnFamilyName ( K_ALTER id= cident K_TYPE v= comparatorType | K_ADD id= cident v= comparatorType | K_DROP id= cident | K_WITH properties[props] ) ;
    public final AlterTableStatement alterTableStatement() throws RecognitionException {
        AlterTableStatement expr = null;

        CFName cf = null;

        ColumnIdentifier id = null;

        ParsedType v = null;



                AlterTableStatement.Type type = null;
                CFPropDefs props = new CFPropDefs();
            
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:449:5: ( K_ALTER K_COLUMNFAMILY cf= columnFamilyName ( K_ALTER id= cident K_TYPE v= comparatorType | K_ADD id= cident v= comparatorType | K_DROP id= cident | K_WITH properties[props] ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:449:7: K_ALTER K_COLUMNFAMILY cf= columnFamilyName ( K_ALTER id= cident K_TYPE v= comparatorType | K_ADD id= cident v= comparatorType | K_DROP id= cident | K_WITH properties[props] )
            {
            match(input,K_ALTER,FOLLOW_K_ALTER_in_alterTableStatement2131); 
            match(input,K_COLUMNFAMILY,FOLLOW_K_COLUMNFAMILY_in_alterTableStatement2133); 
            pushFollow(FOLLOW_columnFamilyName_in_alterTableStatement2137);
            cf=columnFamilyName();

            state._fsp--;

            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:450:11: ( K_ALTER id= cident K_TYPE v= comparatorType | K_ADD id= cident v= comparatorType | K_DROP id= cident | K_WITH properties[props] )
            int alt48=4;
            switch ( input.LA(1) ) {
            case K_ALTER:
                {
                alt48=1;
                }
                break;
            case K_ADD:
                {
                alt48=2;
                }
                break;
            case K_DROP:
                {
                alt48=3;
                }
                break;
            case K_WITH:
                {
                alt48=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:450:13: K_ALTER id= cident K_TYPE v= comparatorType
                    {
                    match(input,K_ALTER,FOLLOW_K_ALTER_in_alterTableStatement2151); 
                    pushFollow(FOLLOW_cident_in_alterTableStatement2155);
                    id=cident();

                    state._fsp--;

                    match(input,K_TYPE,FOLLOW_K_TYPE_in_alterTableStatement2157); 
                    pushFollow(FOLLOW_comparatorType_in_alterTableStatement2161);
                    v=comparatorType();

                    state._fsp--;

                     type = AlterTableStatement.Type.ALTER; 

                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:451:13: K_ADD id= cident v= comparatorType
                    {
                    match(input,K_ADD,FOLLOW_K_ADD_in_alterTableStatement2177); 
                    pushFollow(FOLLOW_cident_in_alterTableStatement2183);
                    id=cident();

                    state._fsp--;

                    pushFollow(FOLLOW_comparatorType_in_alterTableStatement2187);
                    v=comparatorType();

                    state._fsp--;

                     type = AlterTableStatement.Type.ADD; 

                    }
                    break;
                case 3 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:452:13: K_DROP id= cident
                    {
                    match(input,K_DROP,FOLLOW_K_DROP_in_alterTableStatement2210); 
                    pushFollow(FOLLOW_cident_in_alterTableStatement2215);
                    id=cident();

                    state._fsp--;

                     type = AlterTableStatement.Type.DROP; 

                    }
                    break;
                case 4 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:453:13: K_WITH properties[props]
                    {
                    match(input,K_WITH,FOLLOW_K_WITH_in_alterTableStatement2255); 
                    pushFollow(FOLLOW_properties_in_alterTableStatement2258);
                    properties(props);

                    state._fsp--;

                     type = AlterTableStatement.Type.OPTS; 

                    }
                    break;

            }


                    expr = new AlterTableStatement(cf, type, id, v, props);
                

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "alterTableStatement"


    // $ANTLR start "dropKeyspaceStatement"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:460:1: dropKeyspaceStatement returns [DropKeyspaceStatement ksp] : K_DROP K_KEYSPACE ks= keyspaceName ;
    public final DropKeyspaceStatement dropKeyspaceStatement() throws RecognitionException {
        DropKeyspaceStatement ksp = null;

        String ks = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:464:5: ( K_DROP K_KEYSPACE ks= keyspaceName )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:464:7: K_DROP K_KEYSPACE ks= keyspaceName
            {
            match(input,K_DROP,FOLLOW_K_DROP_in_dropKeyspaceStatement2318); 
            match(input,K_KEYSPACE,FOLLOW_K_KEYSPACE_in_dropKeyspaceStatement2320); 
            pushFollow(FOLLOW_keyspaceName_in_dropKeyspaceStatement2324);
            ks=keyspaceName();

            state._fsp--;

             ksp = new DropKeyspaceStatement(ks); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ksp;
    }
    // $ANTLR end "dropKeyspaceStatement"


    // $ANTLR start "dropColumnFamilyStatement"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:467:1: dropColumnFamilyStatement returns [DropColumnFamilyStatement stmt] : K_DROP K_COLUMNFAMILY cf= columnFamilyName ;
    public final DropColumnFamilyStatement dropColumnFamilyStatement() throws RecognitionException {
        DropColumnFamilyStatement stmt = null;

        CFName cf = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:471:5: ( K_DROP K_COLUMNFAMILY cf= columnFamilyName )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:471:7: K_DROP K_COLUMNFAMILY cf= columnFamilyName
            {
            match(input,K_DROP,FOLLOW_K_DROP_in_dropColumnFamilyStatement2349); 
            match(input,K_COLUMNFAMILY,FOLLOW_K_COLUMNFAMILY_in_dropColumnFamilyStatement2351); 
            pushFollow(FOLLOW_columnFamilyName_in_dropColumnFamilyStatement2355);
            cf=columnFamilyName();

            state._fsp--;

             stmt = new DropColumnFamilyStatement(cf); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "dropColumnFamilyStatement"


    // $ANTLR start "dropIndexStatement"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:474:1: dropIndexStatement returns [DropIndexStatement expr] : K_DROP K_INDEX index= IDENT ;
    public final DropIndexStatement dropIndexStatement() throws RecognitionException {
        DropIndexStatement expr = null;

        Token index=null;

        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:478:5: ( K_DROP K_INDEX index= IDENT )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:479:7: K_DROP K_INDEX index= IDENT
            {
            match(input,K_DROP,FOLLOW_K_DROP_in_dropIndexStatement2386); 
            match(input,K_INDEX,FOLLOW_K_INDEX_in_dropIndexStatement2388); 
            index=(Token)match(input,IDENT,FOLLOW_IDENT_in_dropIndexStatement2392); 
             expr = new DropIndexStatement((index!=null?index.getText():null)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "dropIndexStatement"


    // $ANTLR start "truncateStatement"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:483:1: truncateStatement returns [TruncateStatement stmt] : K_TRUNCATE cf= columnFamilyName ;
    public final TruncateStatement truncateStatement() throws RecognitionException {
        TruncateStatement stmt = null;

        CFName cf = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:487:5: ( K_TRUNCATE cf= columnFamilyName )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:487:7: K_TRUNCATE cf= columnFamilyName
            {
            match(input,K_TRUNCATE,FOLLOW_K_TRUNCATE_in_truncateStatement2423); 
            pushFollow(FOLLOW_columnFamilyName_in_truncateStatement2427);
            cf=columnFamilyName();

            state._fsp--;

             stmt = new TruncateStatement(cf); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "truncateStatement"


    // $ANTLR start "grantStatement"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:490:1: grantStatement returns [GrantStatement stmt] : K_GRANT permission K_ON resource= columnFamilyName K_TO user= ( IDENT | STRING_LITERAL ) ( K_WITH K_GRANT K_OPTION )? ;
    public final GrantStatement grantStatement() throws RecognitionException {
        GrantStatement stmt = null;

        Token user=null;
        CFName resource = null;

        Permission permission3 = null;


         boolean withGrant = false; 
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:495:5: ( K_GRANT permission K_ON resource= columnFamilyName K_TO user= ( IDENT | STRING_LITERAL ) ( K_WITH K_GRANT K_OPTION )? )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:495:7: K_GRANT permission K_ON resource= columnFamilyName K_TO user= ( IDENT | STRING_LITERAL ) ( K_WITH K_GRANT K_OPTION )?
            {
            match(input,K_GRANT,FOLLOW_K_GRANT_in_grantStatement2461); 
            pushFollow(FOLLOW_permission_in_grantStatement2473);
            permission3=permission();

            state._fsp--;

            match(input,K_ON,FOLLOW_K_ON_in_grantStatement2481); 
            pushFollow(FOLLOW_columnFamilyName_in_grantStatement2495);
            resource=columnFamilyName();

            state._fsp--;

            match(input,K_TO,FOLLOW_K_TO_in_grantStatement2503); 
            user=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:501:7: ( K_WITH K_GRANT K_OPTION )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==K_WITH) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:501:8: K_WITH K_GRANT K_OPTION
                    {
                    match(input,K_WITH,FOLLOW_K_WITH_in_grantStatement2532); 
                    match(input,K_GRANT,FOLLOW_K_GRANT_in_grantStatement2534); 
                    match(input,K_OPTION,FOLLOW_K_OPTION_in_grantStatement2536); 
                     withGrant = true; 

                    }
                    break;

            }


                    stmt = new GrantStatement(permission3,
                                               resource,
                                               (user!=null?user.getText():null),
                                               withGrant);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "grantStatement"


    // $ANTLR start "revokeStatement"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:510:1: revokeStatement returns [RevokeStatement stmt] : K_REVOKE permission K_ON resource= columnFamilyName K_FROM user= ( IDENT | STRING_LITERAL ) ;
    public final RevokeStatement revokeStatement() throws RecognitionException {
        RevokeStatement stmt = null;

        Token user=null;
        CFName resource = null;

        Permission permission4 = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:514:5: ( K_REVOKE permission K_ON resource= columnFamilyName K_FROM user= ( IDENT | STRING_LITERAL ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:514:7: K_REVOKE permission K_ON resource= columnFamilyName K_FROM user= ( IDENT | STRING_LITERAL )
            {
            match(input,K_REVOKE,FOLLOW_K_REVOKE_in_revokeStatement2571); 
            pushFollow(FOLLOW_permission_in_revokeStatement2581);
            permission4=permission();

            state._fsp--;

            match(input,K_ON,FOLLOW_K_ON_in_revokeStatement2589); 
            pushFollow(FOLLOW_columnFamilyName_in_revokeStatement2601);
            resource=columnFamilyName();

            state._fsp--;

            match(input,K_FROM,FOLLOW_K_FROM_in_revokeStatement2609); 
            user=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


                    stmt = new RevokeStatement(permission4,
                                                (user!=null?user.getText():null),
                                                resource);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "revokeStatement"


    // $ANTLR start "listGrantsStatement"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:527:1: listGrantsStatement returns [ListGrantsStatement stmt] : K_LIST K_GRANTS K_FOR username= ( IDENT | STRING_LITERAL ) ;
    public final ListGrantsStatement listGrantsStatement() throws RecognitionException {
        ListGrantsStatement stmt = null;

        Token username=null;

        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:528:5: ( K_LIST K_GRANTS K_FOR username= ( IDENT | STRING_LITERAL ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:528:7: K_LIST K_GRANTS K_FOR username= ( IDENT | STRING_LITERAL )
            {
            match(input,K_LIST,FOLLOW_K_LIST_in_listGrantsStatement2656); 
            match(input,K_GRANTS,FOLLOW_K_GRANTS_in_listGrantsStatement2658); 
            match(input,K_FOR,FOLLOW_K_FOR_in_listGrantsStatement2660); 
            username=(Token)input.LT(1);
            if ( input.LA(1)==IDENT||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

             stmt = new ListGrantsStatement((username!=null?username.getText():null)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "listGrantsStatement"


    // $ANTLR start "permission"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:531:1: permission returns [Permission perm] : p= ( K_DESCRIBE | K_USE | K_CREATE | K_ALTER | K_DROP | K_SELECT | K_INSERT | K_UPDATE | K_DELETE | K_FULL_ACCESS | K_NO_ACCESS ) ;
    public final Permission permission() throws RecognitionException {
        Permission perm = null;

        Token p=null;

        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:532:5: (p= ( K_DESCRIBE | K_USE | K_CREATE | K_ALTER | K_DROP | K_SELECT | K_INSERT | K_UPDATE | K_DELETE | K_FULL_ACCESS | K_NO_ACCESS ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:532:7: p= ( K_DESCRIBE | K_USE | K_CREATE | K_ALTER | K_DROP | K_SELECT | K_INSERT | K_UPDATE | K_DELETE | K_FULL_ACCESS | K_NO_ACCESS )
            {
            p=(Token)input.LT(1);
            if ( (input.LA(1)>=K_USE && input.LA(1)<=K_SELECT)||input.LA(1)==K_INSERT||input.LA(1)==K_UPDATE||input.LA(1)==K_DELETE||input.LA(1)==K_CREATE||input.LA(1)==K_ALTER||input.LA(1)==K_DROP||(input.LA(1)>=K_DESCRIBE && input.LA(1)<=K_NO_ACCESS) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

             perm = Permission.valueOf((p!=null?p.getText():null).toUpperCase()); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return perm;
    }
    // $ANTLR end "permission"


    // $ANTLR start "cident"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:535:1: cident returns [ColumnIdentifier id] : (t= IDENT | t= QUOTED_NAME | k= unreserved_keyword );
    public final ColumnIdentifier cident() throws RecognitionException {
        ColumnIdentifier id = null;

        Token t=null;
        String k = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:539:5: (t= IDENT | t= QUOTED_NAME | k= unreserved_keyword )
            int alt50=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt50=1;
                }
                break;
            case QUOTED_NAME:
                {
                alt50=2;
                }
                break;
            case K_COUNT:
            case K_CONSISTENCY:
            case K_LEVEL:
            case K_WRITETIME:
            case K_TTL:
            case K_VALUES:
            case K_TIMESTAMP:
            case K_KEY:
            case K_COMPACT:
            case K_STORAGE:
            case K_CLUSTERING:
            case K_TYPE:
            case K_LIST:
            case K_ASCII:
            case K_BIGINT:
            case K_BLOB:
            case K_BOOLEAN:
            case K_COUNTER:
            case K_DECIMAL:
            case K_DOUBLE:
            case K_FLOAT:
            case K_INET:
            case K_INT:
            case K_TEXT:
            case K_UUID:
            case K_VARCHAR:
            case K_VARINT:
            case K_TIMEUUID:
            case K_MAP:
                {
                alt50=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:539:7: t= IDENT
                    {
                    t=(Token)match(input,IDENT,FOLLOW_IDENT_in_cident2769); 
                     id = new ColumnIdentifier((t!=null?t.getText():null), false); 

                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:540:7: t= QUOTED_NAME
                    {
                    t=(Token)match(input,QUOTED_NAME,FOLLOW_QUOTED_NAME_in_cident2794); 
                     id = new ColumnIdentifier((t!=null?t.getText():null), true); 

                    }
                    break;
                case 3 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:541:7: k= unreserved_keyword
                    {
                    pushFollow(FOLLOW_unreserved_keyword_in_cident2813);
                    k=unreserved_keyword();

                    state._fsp--;

                     id = new ColumnIdentifier(k, false); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return id;
    }
    // $ANTLR end "cident"


    // $ANTLR start "keyspaceName"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:545:1: keyspaceName returns [String id] : cfOrKsName[name, true] ;
    public final String keyspaceName() throws RecognitionException {
        String id = null;

         CFName name = new CFName(); 
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:547:5: ( cfOrKsName[name, true] )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:547:7: cfOrKsName[name, true]
            {
            pushFollow(FOLLOW_cfOrKsName_in_keyspaceName2846);
            cfOrKsName(name, true);

            state._fsp--;

             id = name.getKeyspace(); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return id;
    }
    // $ANTLR end "keyspaceName"


    // $ANTLR start "columnFamilyName"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:550:1: columnFamilyName returns [CFName name] : ( cfOrKsName[name, true] '.' )? cfOrKsName[name, false] ;
    public final CFName columnFamilyName() throws RecognitionException {
        CFName name = null;

         name = new CFName(); 
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:552:5: ( ( cfOrKsName[name, true] '.' )? cfOrKsName[name, false] )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:552:7: ( cfOrKsName[name, true] '.' )? cfOrKsName[name, false]
            {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:552:7: ( cfOrKsName[name, true] '.' )?
            int alt51=2;
            alt51 = dfa51.predict(input);
            switch (alt51) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:552:8: cfOrKsName[name, true] '.'
                    {
                    pushFollow(FOLLOW_cfOrKsName_in_columnFamilyName2880);
                    cfOrKsName(name, true);

                    state._fsp--;

                    match(input,120,FOLLOW_120_in_columnFamilyName2883); 

                    }
                    break;

            }

            pushFollow(FOLLOW_cfOrKsName_in_columnFamilyName2887);
            cfOrKsName(name, false);

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return name;
    }
    // $ANTLR end "columnFamilyName"


    // $ANTLR start "cfOrKsName"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:555:1: cfOrKsName[CFName name, boolean isKs] : (t= IDENT | t= QUOTED_NAME | k= unreserved_keyword );
    public final void cfOrKsName(CFName name, boolean isKs) throws RecognitionException {
        Token t=null;
        String k = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:556:5: (t= IDENT | t= QUOTED_NAME | k= unreserved_keyword )
            int alt52=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt52=1;
                }
                break;
            case QUOTED_NAME:
                {
                alt52=2;
                }
                break;
            case K_COUNT:
            case K_CONSISTENCY:
            case K_LEVEL:
            case K_WRITETIME:
            case K_TTL:
            case K_VALUES:
            case K_TIMESTAMP:
            case K_KEY:
            case K_COMPACT:
            case K_STORAGE:
            case K_CLUSTERING:
            case K_TYPE:
            case K_LIST:
            case K_ASCII:
            case K_BIGINT:
            case K_BLOB:
            case K_BOOLEAN:
            case K_COUNTER:
            case K_DECIMAL:
            case K_DOUBLE:
            case K_FLOAT:
            case K_INET:
            case K_INT:
            case K_TEXT:
            case K_UUID:
            case K_VARCHAR:
            case K_VARINT:
            case K_TIMEUUID:
            case K_MAP:
                {
                alt52=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:556:7: t= IDENT
                    {
                    t=(Token)match(input,IDENT,FOLLOW_IDENT_in_cfOrKsName2908); 
                     if (isKs) name.setKeyspace((t!=null?t.getText():null), false); else name.setColumnFamily((t!=null?t.getText():null), false); 

                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:557:7: t= QUOTED_NAME
                    {
                    t=(Token)match(input,QUOTED_NAME,FOLLOW_QUOTED_NAME_in_cfOrKsName2933); 
                     if (isKs) name.setKeyspace((t!=null?t.getText():null), true); else name.setColumnFamily((t!=null?t.getText():null), true); 

                    }
                    break;
                case 3 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:558:7: k= unreserved_keyword
                    {
                    pushFollow(FOLLOW_unreserved_keyword_in_cfOrKsName2952);
                    k=unreserved_keyword();

                    state._fsp--;

                     if (isKs) name.setKeyspace(k, false); else name.setColumnFamily(k, false); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "cfOrKsName"


    // $ANTLR start "set_operation"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:561:1: set_operation returns [Operation op] : (t= term | m= map_literal | l= list_literal | s= set_literal );
    public final Operation set_operation() throws RecognitionException {
        Operation op = null;

        Term t = null;

        Map<Term, Term> m = null;

        List<Term> l = null;

        List<Term> s = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:562:5: (t= term | m= map_literal | l= list_literal | s= set_literal )
            int alt53=4;
            switch ( input.LA(1) ) {
            case INTEGER:
            case STRING_LITERAL:
            case UUID:
            case FLOAT:
            case QMARK:
                {
                alt53=1;
                }
                break;
            case 121:
                {
                switch ( input.LA(2) ) {
                case INTEGER:
                case STRING_LITERAL:
                case UUID:
                case FLOAT:
                    {
                    int LA53_4 = input.LA(3);

                    if ( (LA53_4==116||LA53_4==122) ) {
                        alt53=4;
                    }
                    else if ( (LA53_4==123) ) {
                        alt53=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 53, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case QMARK:
                    {
                    int LA53_5 = input.LA(3);

                    if ( (LA53_5==123) ) {
                        alt53=2;
                    }
                    else if ( (LA53_5==116||LA53_5==122) ) {
                        alt53=4;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 53, 5, input);

                        throw nvae;
                    }
                    }
                    break;
                case 122:
                    {
                    alt53=4;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 2, input);

                    throw nvae;
                }

                }
                break;
            case 118:
                {
                alt53=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:562:7: t= term
                    {
                    pushFollow(FOLLOW_term_in_set_operation2977);
                    t=term();

                    state._fsp--;

                     op = ColumnOperation.Set(t); 

                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:563:7: m= map_literal
                    {
                    pushFollow(FOLLOW_map_literal_in_set_operation2997);
                    m=map_literal();

                    state._fsp--;

                     op = MapOperation.Set(m);  

                    }
                    break;
                case 3 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:564:7: l= list_literal
                    {
                    pushFollow(FOLLOW_list_literal_in_set_operation3010);
                    l=list_literal();

                    state._fsp--;

                     op = ListOperation.Set(l); 

                    }
                    break;
                case 4 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:565:7: s= set_literal
                    {
                    pushFollow(FOLLOW_set_literal_in_set_operation3022);
                    s=set_literal();

                    state._fsp--;

                     op = SetOperation.Set(s);  

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return op;
    }
    // $ANTLR end "set_operation"


    // $ANTLR start "list_literal"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:568:1: list_literal returns [List<Term> value] : '[' (t1= term ( ',' tn= term )* )? ']' ;
    public final List<Term> list_literal() throws RecognitionException {
        List<Term> value = null;

        Term t1 = null;

        Term tn = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:569:5: ( '[' (t1= term ( ',' tn= term )* )? ']' )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:569:7: '[' (t1= term ( ',' tn= term )* )? ']'
            {
            match(input,118,FOLLOW_118_in_list_literal3046); 
             List<Term> l = new ArrayList<Term>(); 
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:569:53: (t1= term ( ',' tn= term )* )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==INTEGER||LA55_0==STRING_LITERAL||(LA55_0>=UUID && LA55_0<=QMARK)) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:569:55: t1= term ( ',' tn= term )*
                    {
                    pushFollow(FOLLOW_term_in_list_literal3054);
                    t1=term();

                    state._fsp--;

                     l.add(t1); 
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:569:78: ( ',' tn= term )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==116) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:569:80: ',' tn= term
                    	    {
                    	    match(input,116,FOLLOW_116_in_list_literal3060); 
                    	    pushFollow(FOLLOW_term_in_list_literal3064);
                    	    tn=term();

                    	    state._fsp--;

                    	     l.add(tn); 

                    	    }
                    	    break;

                    	default :
                    	    break loop54;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,119,FOLLOW_119_in_list_literal3074); 
             value = l; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "list_literal"


    // $ANTLR start "set_literal"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:572:1: set_literal returns [List<Term> value] : '{' (t1= term ( ',' tn= term )* )? '}' ;
    public final List<Term> set_literal() throws RecognitionException {
        List<Term> value = null;

        Term t1 = null;

        Term tn = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:573:5: ( '{' (t1= term ( ',' tn= term )* )? '}' )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:573:7: '{' (t1= term ( ',' tn= term )* )? '}'
            {
            match(input,121,FOLLOW_121_in_set_literal3097); 
             List<Term> s = new ArrayList<Term>(); 
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:573:53: (t1= term ( ',' tn= term )* )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==INTEGER||LA57_0==STRING_LITERAL||(LA57_0>=UUID && LA57_0<=QMARK)) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:573:55: t1= term ( ',' tn= term )*
                    {
                    pushFollow(FOLLOW_term_in_set_literal3105);
                    t1=term();

                    state._fsp--;

                     s.add(t1); 
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:573:78: ( ',' tn= term )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==116) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:573:80: ',' tn= term
                    	    {
                    	    match(input,116,FOLLOW_116_in_set_literal3111); 
                    	    pushFollow(FOLLOW_term_in_set_literal3115);
                    	    tn=term();

                    	    state._fsp--;

                    	     s.add(tn); 

                    	    }
                    	    break;

                    	default :
                    	    break loop56;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,122,FOLLOW_122_in_set_literal3125); 
             value = s; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "set_literal"


    // $ANTLR start "map_literal"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:576:1: map_literal returns [Map<Term, Term> value] : '{' k1= term ':' v1= term ( ',' kn= term ':' vn= term )* '}' ;
    public final Map<Term, Term> map_literal() throws RecognitionException {
        Map<Term, Term> value = null;

        Term k1 = null;

        Term v1 = null;

        Term kn = null;

        Term vn = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:578:5: ( '{' k1= term ':' v1= term ( ',' kn= term ':' vn= term )* '}' )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:578:7: '{' k1= term ':' v1= term ( ',' kn= term ':' vn= term )* '}'
            {
            match(input,121,FOLLOW_121_in_map_literal3154); 
             Map<Term, Term> m = new HashMap<Term, Term>(); 
            pushFollow(FOLLOW_term_in_map_literal3170);
            k1=term();

            state._fsp--;

            match(input,123,FOLLOW_123_in_map_literal3172); 
            pushFollow(FOLLOW_term_in_map_literal3176);
            v1=term();

            state._fsp--;

             m.put(k1, v1); 
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:579:50: ( ',' kn= term ':' vn= term )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==116) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:579:52: ',' kn= term ':' vn= term
            	    {
            	    match(input,116,FOLLOW_116_in_map_literal3182); 
            	    pushFollow(FOLLOW_term_in_map_literal3186);
            	    kn=term();

            	    state._fsp--;

            	    match(input,123,FOLLOW_123_in_map_literal3188); 
            	    pushFollow(FOLLOW_term_in_map_literal3192);
            	    vn=term();

            	    state._fsp--;

            	     m.put(kn, vn); 

            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);

            match(input,122,FOLLOW_122_in_map_literal3199); 
             value = m; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "map_literal"


    // $ANTLR start "term"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:583:1: term returns [Term term] : (t= ( STRING_LITERAL | UUID | INTEGER | FLOAT ) | t= QMARK );
    public final Term term() throws RecognitionException {
        Term term = null;

        Token t=null;

        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:584:5: (t= ( STRING_LITERAL | UUID | INTEGER | FLOAT ) | t= QMARK )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==INTEGER||LA59_0==STRING_LITERAL||(LA59_0>=UUID && LA59_0<=FLOAT)) ) {
                alt59=1;
            }
            else if ( (LA59_0==QMARK) ) {
                alt59=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:584:7: t= ( STRING_LITERAL | UUID | INTEGER | FLOAT )
                    {
                    t=(Token)input.LT(1);
                    if ( input.LA(1)==INTEGER||input.LA(1)==STRING_LITERAL||(input.LA(1)>=UUID && input.LA(1)<=FLOAT) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                     term = new Term((t!=null?t.getText():null), (t!=null?t.getType():0)); 

                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:585:7: t= QMARK
                    {
                    t=(Token)match(input,QMARK,FOLLOW_QMARK_in_term3258); 
                     term = new Term((t!=null?t.getText():null), (t!=null?t.getType():0), ++currentBindMarkerIdx); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return term;
    }
    // $ANTLR end "term"


    // $ANTLR start "intTerm"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:588:1: intTerm returns [Term integer] : (t= INTEGER | t= QMARK );
    public final Term intTerm() throws RecognitionException {
        Term integer = null;

        Token t=null;

        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:589:5: (t= INTEGER | t= QMARK )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==INTEGER) ) {
                alt60=1;
            }
            else if ( (LA60_0==QMARK) ) {
                alt60=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:589:7: t= INTEGER
                    {
                    t=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_intTerm3320); 
                     integer = new Term((t!=null?t.getText():null), (t!=null?t.getType():0)); 

                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:590:7: t= QMARK
                    {
                    t=(Token)match(input,QMARK,FOLLOW_QMARK_in_intTerm3332); 
                     integer = new Term((t!=null?t.getText():null), (t!=null?t.getType():0), ++currentBindMarkerIdx); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return integer;
    }
    // $ANTLR end "intTerm"


    // $ANTLR start "termPairWithOperation"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:593:1: termPairWithOperation[List<Pair<ColumnIdentifier, Operation>> columns] : (key= cident '=' (set_op= set_operation | c= cident op= operation | ll= list_literal '+' c= cident ) | key= cident '[' t= term ']' '=' vv= term );
    public final void termPairWithOperation(List<Pair<ColumnIdentifier, Operation>> columns) throws RecognitionException {
        ColumnIdentifier key = null;

        Operation set_op = null;

        ColumnIdentifier c = null;

        Operation op = null;

        List<Term> ll = null;

        Term t = null;

        Term vv = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:594:5: (key= cident '=' (set_op= set_operation | c= cident op= operation | ll= list_literal '+' c= cident ) | key= cident '[' t= term ']' '=' vv= term )
            int alt62=2;
            alt62 = dfa62.predict(input);
            switch (alt62) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:594:7: key= cident '=' (set_op= set_operation | c= cident op= operation | ll= list_literal '+' c= cident )
                    {
                    pushFollow(FOLLOW_cident_in_termPairWithOperation3356);
                    key=cident();

                    state._fsp--;

                    match(input,124,FOLLOW_124_in_termPairWithOperation3358); 
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:595:9: (set_op= set_operation | c= cident op= operation | ll= list_literal '+' c= cident )
                    int alt61=3;
                    alt61 = dfa61.predict(input);
                    switch (alt61) {
                        case 1 :
                            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:595:10: set_op= set_operation
                            {
                            pushFollow(FOLLOW_set_operation_in_termPairWithOperation3373);
                            set_op=set_operation();

                            state._fsp--;

                             columns.add(Pair.<ColumnIdentifier, Operation>create(key, set_op)); 

                            }
                            break;
                        case 2 :
                            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:596:11: c= cident op= operation
                            {
                            pushFollow(FOLLOW_cident_in_termPairWithOperation3389);
                            c=cident();

                            state._fsp--;

                            pushFollow(FOLLOW_operation_in_termPairWithOperation3393);
                            op=operation();

                            state._fsp--;


                                          if (!key.equals(c))
                                              addRecognitionError("Only expressions like X = X <op> <value> are supported.");
                                          columns.add(Pair.<ColumnIdentifier, Operation>create(key, op));
                                      

                            }
                            break;
                        case 3 :
                            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:602:11: ll= list_literal '+' c= cident
                            {
                            pushFollow(FOLLOW_list_literal_in_termPairWithOperation3419);
                            ll=list_literal();

                            state._fsp--;

                            match(input,125,FOLLOW_125_in_termPairWithOperation3421); 
                            pushFollow(FOLLOW_cident_in_termPairWithOperation3425);
                            c=cident();

                            state._fsp--;


                                          if (!key.equals(c))
                                              addRecognitionError("Only expressions like X = <value> + X are supported.");
                                          columns.add(Pair.<ColumnIdentifier, Operation>create(key, ListOperation.Prepend(ll)));
                                      

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:609:7: key= cident '[' t= term ']' '=' vv= term
                    {
                    pushFollow(FOLLOW_cident_in_termPairWithOperation3457);
                    key=cident();

                    state._fsp--;

                    match(input,118,FOLLOW_118_in_termPairWithOperation3459); 
                    pushFollow(FOLLOW_term_in_termPairWithOperation3463);
                    t=term();

                    state._fsp--;

                    match(input,119,FOLLOW_119_in_termPairWithOperation3465); 
                    match(input,124,FOLLOW_124_in_termPairWithOperation3467); 
                    pushFollow(FOLLOW_term_in_termPairWithOperation3471);
                    vv=term();

                    state._fsp--;


                              Operation setOp = (t.getType() == Term.Type.INTEGER)
                                                 ? ListOperation.SetIndex(Arrays.asList(t, vv))
                                                 : MapOperation.Put(t, vv);

                              columns.add(Pair.<ColumnIdentifier, Operation>create(key, setOp));
                          

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "termPairWithOperation"


    // $ANTLR start "operation"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:619:1: operation returns [Operation op] : ( '+' v= intTerm | (sign= '-' )? v= intTerm | '+' ll= list_literal | '-' ll= list_literal | '+' sl= set_literal | '-' sl= set_literal | '+' ml= map_literal );
    public final Operation operation() throws RecognitionException {
        Operation op = null;

        Token sign=null;
        Term v = null;

        List<Term> ll = null;

        List<Term> sl = null;

        Map<Term, Term> ml = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:620:5: ( '+' v= intTerm | (sign= '-' )? v= intTerm | '+' ll= list_literal | '-' ll= list_literal | '+' sl= set_literal | '-' sl= set_literal | '+' ml= map_literal )
            int alt64=7;
            alt64 = dfa64.predict(input);
            switch (alt64) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:620:7: '+' v= intTerm
                    {
                    match(input,125,FOLLOW_125_in_operation3500); 
                    pushFollow(FOLLOW_intTerm_in_operation3504);
                    v=intTerm();

                    state._fsp--;

                     op = ColumnOperation.CounterInc(v); 

                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:621:7: (sign= '-' )? v= intTerm
                    {
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:621:11: (sign= '-' )?
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==126) ) {
                        alt63=1;
                    }
                    switch (alt63) {
                        case 1 :
                            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:621:11: sign= '-'
                            {
                            sign=(Token)match(input,126,FOLLOW_126_in_operation3516); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_intTerm_in_operation3521);
                    v=intTerm();

                    state._fsp--;


                              validateMinusSupplied(sign, v, input);
                              if (sign == null)
                                  v = new Term(-(Long.valueOf(v.getText())), v.getType());
                              op = ColumnOperation.CounterDec(v);
                          

                    }
                    break;
                case 3 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:628:7: '+' ll= list_literal
                    {
                    match(input,125,FOLLOW_125_in_operation3537); 
                    pushFollow(FOLLOW_list_literal_in_operation3541);
                    ll=list_literal();

                    state._fsp--;

                     op = ListOperation.Append(ll); 

                    }
                    break;
                case 4 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:629:7: '-' ll= list_literal
                    {
                    match(input,126,FOLLOW_126_in_operation3551); 
                    pushFollow(FOLLOW_list_literal_in_operation3555);
                    ll=list_literal();

                    state._fsp--;

                     op = ListOperation.Discard(ll); 

                    }
                    break;
                case 5 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:631:7: '+' sl= set_literal
                    {
                    match(input,125,FOLLOW_125_in_operation3566); 
                    pushFollow(FOLLOW_set_literal_in_operation3570);
                    sl=set_literal();

                    state._fsp--;

                     op = SetOperation.Add(sl); 

                    }
                    break;
                case 6 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:632:7: '-' sl= set_literal
                    {
                    match(input,126,FOLLOW_126_in_operation3580); 
                    pushFollow(FOLLOW_set_literal_in_operation3584);
                    sl=set_literal();

                    state._fsp--;

                     op = SetOperation.Discard(sl); 

                    }
                    break;
                case 7 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:634:7: '+' ml= map_literal
                    {
                    match(input,125,FOLLOW_125_in_operation3595); 
                    pushFollow(FOLLOW_map_literal_in_operation3599);
                    ml=map_literal();

                    state._fsp--;

                     op = MapOperation.Put(ml); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return op;
    }
    // $ANTLR end "operation"


    // $ANTLR start "properties"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:637:1: properties[PropertyDefinitions props] : property[props] ( K_AND property[props] )* ;
    public final void properties(PropertyDefinitions props) throws RecognitionException {
        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:638:5: ( property[props] ( K_AND property[props] )* )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:638:7: property[props] ( K_AND property[props] )*
            {
            pushFollow(FOLLOW_property_in_properties3619);
            property(props);

            state._fsp--;

            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:638:23: ( K_AND property[props] )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==K_AND) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:638:24: K_AND property[props]
            	    {
            	    match(input,K_AND,FOLLOW_K_AND_in_properties3623); 
            	    pushFollow(FOLLOW_property_in_properties3625);
            	    property(props);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "properties"


    // $ANTLR start "property"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:641:1: property[PropertyDefinitions props] : k= cident '=' (simple= propertyValue | map= map_literal ) ;
    public final void property(PropertyDefinitions props) throws RecognitionException {
        ColumnIdentifier k = null;

        String simple = null;

        Map<Term, Term> map = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:642:5: (k= cident '=' (simple= propertyValue | map= map_literal ) )
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:642:7: k= cident '=' (simple= propertyValue | map= map_literal )
            {
            pushFollow(FOLLOW_cident_in_property3648);
            k=cident();

            state._fsp--;

            match(input,124,FOLLOW_124_in_property3650); 
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:642:20: (simple= propertyValue | map= map_literal )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==K_COUNT||(LA66_0>=K_CONSISTENCY && LA66_0<=K_LEVEL)||(LA66_0>=INTEGER && LA66_0<=K_TTL)||(LA66_0>=K_VALUES && LA66_0<=K_TIMESTAMP)||(LA66_0>=K_KEY && LA66_0<=K_CLUSTERING)||LA66_0==IDENT||LA66_0==K_TYPE||LA66_0==STRING_LITERAL||LA66_0==K_LIST||LA66_0==FLOAT||(LA66_0>=K_ASCII && LA66_0<=K_MAP)) ) {
                alt66=1;
            }
            else if ( (LA66_0==121) ) {
                alt66=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:642:21: simple= propertyValue
                    {
                    pushFollow(FOLLOW_propertyValue_in_property3655);
                    simple=propertyValue();

                    state._fsp--;

                     try { props.addProperty(k.toString(), simple); } catch (SyntaxException e) { addRecognitionError(e.getMessage()); } 

                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:643:24: map= map_literal
                    {
                    pushFollow(FOLLOW_map_literal_in_property3684);
                    map=map_literal();

                    state._fsp--;

                     try { props.addProperty(k.toString(), convertMap(map)); } catch (SyntaxException e) { addRecognitionError(e.getMessage()); } 

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "property"


    // $ANTLR start "propertyValue"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:646:1: propertyValue returns [String str] : (v= ( STRING_LITERAL | IDENT | INTEGER | FLOAT ) | u= unreserved_keyword );
    public final String propertyValue() throws RecognitionException {
        String str = null;

        Token v=null;
        String u = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:647:5: (v= ( STRING_LITERAL | IDENT | INTEGER | FLOAT ) | u= unreserved_keyword )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==INTEGER||LA67_0==IDENT||LA67_0==STRING_LITERAL||LA67_0==FLOAT) ) {
                alt67=1;
            }
            else if ( (LA67_0==K_COUNT||(LA67_0>=K_CONSISTENCY && LA67_0<=K_LEVEL)||(LA67_0>=K_WRITETIME && LA67_0<=K_TTL)||(LA67_0>=K_VALUES && LA67_0<=K_TIMESTAMP)||(LA67_0>=K_KEY && LA67_0<=K_CLUSTERING)||LA67_0==K_TYPE||LA67_0==K_LIST||(LA67_0>=K_ASCII && LA67_0<=K_MAP)) ) {
                alt67=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:647:7: v= ( STRING_LITERAL | IDENT | INTEGER | FLOAT )
                    {
                    v=(Token)input.LT(1);
                    if ( input.LA(1)==INTEGER||input.LA(1)==IDENT||input.LA(1)==STRING_LITERAL||input.LA(1)==FLOAT ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                     str = (v!=null?v.getText():null); 

                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:648:7: u= unreserved_keyword
                    {
                    pushFollow(FOLLOW_unreserved_keyword_in_propertyValue3738);
                    u=unreserved_keyword();

                    state._fsp--;

                     str = u; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return str;
    }
    // $ANTLR end "propertyValue"


    // $ANTLR start "tokenDefinition"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:652:1: tokenDefinition returns [Pair<String, List<Term>> tkdef] : ( K_TOKEN '(' t1= term ( ',' tn= term )* ')' | t= STRING_LITERAL );
    public final Pair<String, List<Term>> tokenDefinition() throws RecognitionException {
        Pair<String, List<Term>> tkdef = null;

        Token t=null;
        Term t1 = null;

        Term tn = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:653:5: ( K_TOKEN '(' t1= term ( ',' tn= term )* ')' | t= STRING_LITERAL )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==K_TOKEN) ) {
                alt69=1;
            }
            else if ( (LA69_0==STRING_LITERAL) ) {
                alt69=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:653:7: K_TOKEN '(' t1= term ( ',' tn= term )* ')'
                    {
                    match(input,K_TOKEN,FOLLOW_K_TOKEN_in_tokenDefinition3786); 
                     List<Term> l = new ArrayList<Term>(); 
                    match(input,114,FOLLOW_114_in_tokenDefinition3799); 
                    pushFollow(FOLLOW_term_in_tokenDefinition3803);
                    t1=term();

                    state._fsp--;

                     l.add(t1); 
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:654:37: ( ',' tn= term )*
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==116) ) {
                            alt68=1;
                        }


                        switch (alt68) {
                    	case 1 :
                    	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:654:39: ',' tn= term
                    	    {
                    	    match(input,116,FOLLOW_116_in_tokenDefinition3809); 
                    	    pushFollow(FOLLOW_term_in_tokenDefinition3813);
                    	    tn=term();

                    	    state._fsp--;

                    	     l.add(tn); 

                    	    }
                    	    break;

                    	default :
                    	    break loop68;
                        }
                    } while (true);

                    match(input,115,FOLLOW_115_in_tokenDefinition3821); 
                     tkdef = Pair.<String, List<Term>>create(null, l); 

                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:655:7: t= STRING_LITERAL
                    {
                    t=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_tokenDefinition3833); 
                     tkdef = Pair.<String, List<Term>>create((t!=null?t.getText():null), null); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return tkdef;
    }
    // $ANTLR end "tokenDefinition"


    // $ANTLR start "relation"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:658:1: relation[List<Relation> clauses] : (name= cident type= ( '=' | '<' | '<=' | '>=' | '>' ) t= term | K_TOKEN '(' name1= cident ( ',' namen= cident )* ')' type= ( '=' | '<' | '<=' | '>=' | '>' ) tkd= tokenDefinition | name= cident K_IN '(' f1= term ( ',' fN= term )* ')' );
    public final void relation(List<Relation> clauses) throws RecognitionException {
        Token type=null;
        ColumnIdentifier name = null;

        Term t = null;

        ColumnIdentifier name1 = null;

        ColumnIdentifier namen = null;

        Pair<String, List<Term>> tkd = null;

        Term f1 = null;

        Term fN = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:659:5: (name= cident type= ( '=' | '<' | '<=' | '>=' | '>' ) t= term | K_TOKEN '(' name1= cident ( ',' namen= cident )* ')' type= ( '=' | '<' | '<=' | '>=' | '>' ) tkd= tokenDefinition | name= cident K_IN '(' f1= term ( ',' fN= term )* ')' )
            int alt72=3;
            alt72 = dfa72.predict(input);
            switch (alt72) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:659:7: name= cident type= ( '=' | '<' | '<=' | '>=' | '>' ) t= term
                    {
                    pushFollow(FOLLOW_cident_in_relation3855);
                    name=cident();

                    state._fsp--;

                    type=(Token)input.LT(1);
                    if ( input.LA(1)==124||(input.LA(1)>=127 && input.LA(1)<=130) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_term_in_relation3881);
                    t=term();

                    state._fsp--;

                     clauses.add(new Relation(name, (type!=null?type.getText():null), t)); 

                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:660:7: K_TOKEN '(' name1= cident ( ',' namen= cident )* ')' type= ( '=' | '<' | '<=' | '>=' | '>' ) tkd= tokenDefinition
                    {
                    match(input,K_TOKEN,FOLLOW_K_TOKEN_in_relation3891); 
                     List<ColumnIdentifier> l = new ArrayList<ColumnIdentifier>(); 
                    match(input,114,FOLLOW_114_in_relation3902); 
                    pushFollow(FOLLOW_cident_in_relation3906);
                    name1=cident();

                    state._fsp--;

                     l.add(name1); 
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:661:43: ( ',' namen= cident )*
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);

                        if ( (LA70_0==116) ) {
                            alt70=1;
                        }


                        switch (alt70) {
                    	case 1 :
                    	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:661:45: ',' namen= cident
                    	    {
                    	    match(input,116,FOLLOW_116_in_relation3912); 
                    	    pushFollow(FOLLOW_cident_in_relation3916);
                    	    namen=cident();

                    	    state._fsp--;

                    	     l.add(namen); 

                    	    }
                    	    break;

                    	default :
                    	    break loop70;
                        }
                    } while (true);

                    match(input,115,FOLLOW_115_in_relation3922); 
                    type=(Token)input.LT(1);
                    if ( input.LA(1)==124||(input.LA(1)>=127 && input.LA(1)<=130) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_tokenDefinition_in_relation3958);
                    tkd=tokenDefinition();

                    state._fsp--;


                               if (tkd.right != null && tkd.right.size() != l.size())
                               {
                                   addRecognitionError("The number of arguments to the token() function don't match");
                               }
                               else
                               {
                                   Term str = tkd.left == null ? null : new Term(tkd.left, Term.Type.STRING);
                                   for (int i = 0; i < l.size(); i++)
                                   {
                                       Term tt = str == null ? Term.tokenOf(tkd.right.get(i)) : str;
                                       clauses.add(new Relation(l.get(i), (type!=null?type.getText():null), tt, true));
                                   }
                               }
                           

                    }
                    break;
                case 3 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:678:7: name= cident K_IN '(' f1= term ( ',' fN= term )* ')'
                    {
                    pushFollow(FOLLOW_cident_in_relation3977);
                    name=cident();

                    state._fsp--;

                    match(input,K_IN,FOLLOW_K_IN_in_relation3979); 
                     Relation rel = Relation.createInRelation(name); 
                    match(input,114,FOLLOW_114_in_relation3990); 
                    pushFollow(FOLLOW_term_in_relation3994);
                    f1=term();

                    state._fsp--;

                     rel.addInValue(f1); 
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:679:44: ( ',' fN= term )*
                    loop71:
                    do {
                        int alt71=2;
                        int LA71_0 = input.LA(1);

                        if ( (LA71_0==116) ) {
                            alt71=1;
                        }


                        switch (alt71) {
                    	case 1 :
                    	    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:679:45: ',' fN= term
                    	    {
                    	    match(input,116,FOLLOW_116_in_relation3999); 
                    	    pushFollow(FOLLOW_term_in_relation4003);
                    	    fN=term();

                    	    state._fsp--;

                    	     rel.addInValue(fN); 

                    	    }
                    	    break;

                    	default :
                    	    break loop71;
                        }
                    } while (true);

                    match(input,115,FOLLOW_115_in_relation4010); 
                     clauses.add(rel); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "relation"


    // $ANTLR start "comparatorType"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:682:1: comparatorType returns [ParsedType t] : (c= native_type | c= collection_type | s= STRING_LITERAL );
    public final ParsedType comparatorType() throws RecognitionException {
        ParsedType t = null;

        Token s=null;
        ParsedType c = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:683:5: (c= native_type | c= collection_type | s= STRING_LITERAL )
            int alt73=3;
            switch ( input.LA(1) ) {
            case K_TIMESTAMP:
            case K_ASCII:
            case K_BIGINT:
            case K_BLOB:
            case K_BOOLEAN:
            case K_COUNTER:
            case K_DECIMAL:
            case K_DOUBLE:
            case K_FLOAT:
            case K_INET:
            case K_INT:
            case K_TEXT:
            case K_UUID:
            case K_VARCHAR:
            case K_VARINT:
            case K_TIMEUUID:
                {
                alt73=1;
                }
                break;
            case K_SET:
            case K_LIST:
            case K_MAP:
                {
                alt73=2;
                }
                break;
            case STRING_LITERAL:
                {
                alt73=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }

            switch (alt73) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:683:7: c= native_type
                    {
                    pushFollow(FOLLOW_native_type_in_comparatorType4035);
                    c=native_type();

                    state._fsp--;

                     t = c; 

                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:684:7: c= collection_type
                    {
                    pushFollow(FOLLOW_collection_type_in_comparatorType4051);
                    c=collection_type();

                    state._fsp--;

                     t = c; 

                    }
                    break;
                case 3 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:685:7: s= STRING_LITERAL
                    {
                    s=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_comparatorType4063); 

                            try {
                                t = new ParsedType.Custom((s!=null?s.getText():null));
                            } catch (SyntaxException e) {
                                addRecognitionError("Cannot parse type " + (s!=null?s.getText():null) + ": " + e.getMessage());
                            } catch (ConfigurationException e) {
                                addRecognitionError("Errot setting type " + (s!=null?s.getText():null) + ": " + e.getMessage());
                            }
                          

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return t;
    }
    // $ANTLR end "comparatorType"


    // $ANTLR start "native_type"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:697:1: native_type returns [ParsedType t] : ( K_ASCII | K_BIGINT | K_BLOB | K_BOOLEAN | K_COUNTER | K_DECIMAL | K_DOUBLE | K_FLOAT | K_INET | K_INT | K_TEXT | K_TIMESTAMP | K_UUID | K_VARCHAR | K_VARINT | K_TIMEUUID );
    public final ParsedType native_type() throws RecognitionException {
        ParsedType t = null;

        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:698:5: ( K_ASCII | K_BIGINT | K_BLOB | K_BOOLEAN | K_COUNTER | K_DECIMAL | K_DOUBLE | K_FLOAT | K_INET | K_INT | K_TEXT | K_TIMESTAMP | K_UUID | K_VARCHAR | K_VARINT | K_TIMEUUID )
            int alt74=16;
            switch ( input.LA(1) ) {
            case K_ASCII:
                {
                alt74=1;
                }
                break;
            case K_BIGINT:
                {
                alt74=2;
                }
                break;
            case K_BLOB:
                {
                alt74=3;
                }
                break;
            case K_BOOLEAN:
                {
                alt74=4;
                }
                break;
            case K_COUNTER:
                {
                alt74=5;
                }
                break;
            case K_DECIMAL:
                {
                alt74=6;
                }
                break;
            case K_DOUBLE:
                {
                alt74=7;
                }
                break;
            case K_FLOAT:
                {
                alt74=8;
                }
                break;
            case K_INET:
                {
                alt74=9;
                }
                break;
            case K_INT:
                {
                alt74=10;
                }
                break;
            case K_TEXT:
                {
                alt74=11;
                }
                break;
            case K_TIMESTAMP:
                {
                alt74=12;
                }
                break;
            case K_UUID:
                {
                alt74=13;
                }
                break;
            case K_VARCHAR:
                {
                alt74=14;
                }
                break;
            case K_VARINT:
                {
                alt74=15;
                }
                break;
            case K_TIMEUUID:
                {
                alt74=16;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }

            switch (alt74) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:698:7: K_ASCII
                    {
                    match(input,K_ASCII,FOLLOW_K_ASCII_in_native_type4092); 
                     t = ParsedType.Native.ASCII; 

                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:699:7: K_BIGINT
                    {
                    match(input,K_BIGINT,FOLLOW_K_BIGINT_in_native_type4106); 
                     t = ParsedType.Native.BIGINT; 

                    }
                    break;
                case 3 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:700:7: K_BLOB
                    {
                    match(input,K_BLOB,FOLLOW_K_BLOB_in_native_type4119); 
                     t = ParsedType.Native.BLOB; 

                    }
                    break;
                case 4 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:701:7: K_BOOLEAN
                    {
                    match(input,K_BOOLEAN,FOLLOW_K_BOOLEAN_in_native_type4134); 
                     t = ParsedType.Native.BOOLEAN; 

                    }
                    break;
                case 5 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:702:7: K_COUNTER
                    {
                    match(input,K_COUNTER,FOLLOW_K_COUNTER_in_native_type4146); 
                     t = ParsedType.Native.COUNTER; 

                    }
                    break;
                case 6 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:703:7: K_DECIMAL
                    {
                    match(input,K_DECIMAL,FOLLOW_K_DECIMAL_in_native_type4158); 
                     t = ParsedType.Native.DECIMAL; 

                    }
                    break;
                case 7 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:704:7: K_DOUBLE
                    {
                    match(input,K_DOUBLE,FOLLOW_K_DOUBLE_in_native_type4170); 
                     t = ParsedType.Native.DOUBLE; 

                    }
                    break;
                case 8 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:705:7: K_FLOAT
                    {
                    match(input,K_FLOAT,FOLLOW_K_FLOAT_in_native_type4183); 
                     t = ParsedType.Native.FLOAT; 

                    }
                    break;
                case 9 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:706:7: K_INET
                    {
                    match(input,K_INET,FOLLOW_K_INET_in_native_type4197); 
                     t = ParsedType.Native.INET;

                    }
                    break;
                case 10 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:707:7: K_INT
                    {
                    match(input,K_INT,FOLLOW_K_INT_in_native_type4212); 
                     t = ParsedType.Native.INT; 

                    }
                    break;
                case 11 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:708:7: K_TEXT
                    {
                    match(input,K_TEXT,FOLLOW_K_TEXT_in_native_type4228); 
                     t = ParsedType.Native.TEXT; 

                    }
                    break;
                case 12 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:709:7: K_TIMESTAMP
                    {
                    match(input,K_TIMESTAMP,FOLLOW_K_TIMESTAMP_in_native_type4243); 
                     t = ParsedType.Native.TIMESTAMP; 

                    }
                    break;
                case 13 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:710:7: K_UUID
                    {
                    match(input,K_UUID,FOLLOW_K_UUID_in_native_type4253); 
                     t = ParsedType.Native.UUID; 

                    }
                    break;
                case 14 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:711:7: K_VARCHAR
                    {
                    match(input,K_VARCHAR,FOLLOW_K_VARCHAR_in_native_type4268); 
                     t = ParsedType.Native.VARCHAR; 

                    }
                    break;
                case 15 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:712:7: K_VARINT
                    {
                    match(input,K_VARINT,FOLLOW_K_VARINT_in_native_type4280); 
                     t = ParsedType.Native.VARINT; 

                    }
                    break;
                case 16 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:713:7: K_TIMEUUID
                    {
                    match(input,K_TIMEUUID,FOLLOW_K_TIMEUUID_in_native_type4293); 
                     t = ParsedType.Native.TIMEUUID; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return t;
    }
    // $ANTLR end "native_type"


    // $ANTLR start "collection_type"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:716:1: collection_type returns [ParsedType pt] : ( K_MAP '<' t1= comparatorType ',' t2= comparatorType '>' | K_LIST '<' t= comparatorType '>' | K_SET '<' t= comparatorType '>' );
    public final ParsedType collection_type() throws RecognitionException {
        ParsedType pt = null;

        ParsedType t1 = null;

        ParsedType t2 = null;

        ParsedType t = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:717:5: ( K_MAP '<' t1= comparatorType ',' t2= comparatorType '>' | K_LIST '<' t= comparatorType '>' | K_SET '<' t= comparatorType '>' )
            int alt75=3;
            switch ( input.LA(1) ) {
            case K_MAP:
                {
                alt75=1;
                }
                break;
            case K_LIST:
                {
                alt75=2;
                }
                break;
            case K_SET:
                {
                alt75=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }

            switch (alt75) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:717:7: K_MAP '<' t1= comparatorType ',' t2= comparatorType '>'
                    {
                    match(input,K_MAP,FOLLOW_K_MAP_in_collection_type4317); 
                    match(input,127,FOLLOW_127_in_collection_type4320); 
                    pushFollow(FOLLOW_comparatorType_in_collection_type4324);
                    t1=comparatorType();

                    state._fsp--;

                    match(input,116,FOLLOW_116_in_collection_type4326); 
                    pushFollow(FOLLOW_comparatorType_in_collection_type4330);
                    t2=comparatorType();

                    state._fsp--;

                    match(input,130,FOLLOW_130_in_collection_type4332); 
                     try { pt = ParsedType.Collection.map(t1, t2); } catch (InvalidRequestException e) { addRecognitionError(e.getMessage()); } 

                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:719:7: K_LIST '<' t= comparatorType '>'
                    {
                    match(input,K_LIST,FOLLOW_K_LIST_in_collection_type4350); 
                    match(input,127,FOLLOW_127_in_collection_type4352); 
                    pushFollow(FOLLOW_comparatorType_in_collection_type4356);
                    t=comparatorType();

                    state._fsp--;

                    match(input,130,FOLLOW_130_in_collection_type4358); 
                     try { pt = ParsedType.Collection.list(t); } catch (InvalidRequestException e) { addRecognitionError(e.getMessage()); } 

                    }
                    break;
                case 3 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:721:7: K_SET '<' t= comparatorType '>'
                    {
                    match(input,K_SET,FOLLOW_K_SET_in_collection_type4376); 
                    match(input,127,FOLLOW_127_in_collection_type4379); 
                    pushFollow(FOLLOW_comparatorType_in_collection_type4383);
                    t=comparatorType();

                    state._fsp--;

                    match(input,130,FOLLOW_130_in_collection_type4385); 
                     try { pt = ParsedType.Collection.set(t); } catch (InvalidRequestException e) { addRecognitionError(e.getMessage()); } 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return pt;
    }
    // $ANTLR end "collection_type"


    // $ANTLR start "unreserved_keyword"
    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:725:1: unreserved_keyword returns [String str] : (k= ( K_KEY | K_CONSISTENCY | K_CLUSTERING | K_LEVEL | K_COUNT | K_TTL | K_COMPACT | K_STORAGE | K_TYPE | K_VALUES | K_WRITETIME | K_MAP | K_LIST ) | t= native_type );
    public final String unreserved_keyword() throws RecognitionException {
        String str = null;

        Token k=null;
        ParsedType t = null;


        try {
            // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:726:5: (k= ( K_KEY | K_CONSISTENCY | K_CLUSTERING | K_LEVEL | K_COUNT | K_TTL | K_COMPACT | K_STORAGE | K_TYPE | K_VALUES | K_WRITETIME | K_MAP | K_LIST ) | t= native_type )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==K_COUNT||(LA76_0>=K_CONSISTENCY && LA76_0<=K_LEVEL)||(LA76_0>=K_WRITETIME && LA76_0<=K_TTL)||LA76_0==K_VALUES||(LA76_0>=K_KEY && LA76_0<=K_CLUSTERING)||LA76_0==K_TYPE||LA76_0==K_LIST||LA76_0==K_MAP) ) {
                alt76=1;
            }
            else if ( (LA76_0==K_TIMESTAMP||(LA76_0>=K_ASCII && LA76_0<=K_TIMEUUID)) ) {
                alt76=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:726:7: k= ( K_KEY | K_CONSISTENCY | K_CLUSTERING | K_LEVEL | K_COUNT | K_TTL | K_COMPACT | K_STORAGE | K_TYPE | K_VALUES | K_WRITETIME | K_MAP | K_LIST )
                    {
                    k=(Token)input.LT(1);
                    if ( input.LA(1)==K_COUNT||(input.LA(1)>=K_CONSISTENCY && input.LA(1)<=K_LEVEL)||(input.LA(1)>=K_WRITETIME && input.LA(1)<=K_TTL)||input.LA(1)==K_VALUES||(input.LA(1)>=K_KEY && input.LA(1)<=K_CLUSTERING)||input.LA(1)==K_TYPE||input.LA(1)==K_LIST||input.LA(1)==K_MAP ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                     str = (k!=null?k.getText():null); 

                    }
                    break;
                case 2 :
                    // /home/jeff/Programs/sclck/cassandra-1.2.0-beta-src/src/java/org/apache/cassandra/cql3/Cql.g:740:7: t= native_type
                    {
                    pushFollow(FOLLOW_native_type_in_unreserved_keyword4586);
                    t=native_type();

                    state._fsp--;

                     str = t.toString(); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return str;
    }
    // $ANTLR end "unreserved_keyword"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA51 dfa51 = new DFA51(this);
    protected DFA62 dfa62 = new DFA62(this);
    protected DFA61 dfa61 = new DFA61(this);
    protected DFA64 dfa64 = new DFA64(this);
    protected DFA72 dfa72 = new DFA72(this);
    static final String DFA2_eotS =
        "\26\uffff";
    static final String DFA2_eofS =
        "\26\uffff";
    static final String DFA2_minS =
        "\1\4\7\uffff\3\40\13\uffff";
    static final String DFA2_maxS =
        "\1\65\7\uffff\2\50\1\42\13\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\3\uffff\1\17\1\20\1\21\1\10"+
        "\1\11\1\12\1\13\1\14\1\15\1\16\1\22";
    static final String DFA2_specialS =
        "\26\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\6\1\1\17\uffff\1\2\3\uffff\1\3\1\uffff\1\5\1\4\2\uffff\1"+
            "\10\13\uffff\1\12\2\uffff\1\11\1\7\1\13\3\uffff\1\14\1\15",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\16\1\uffff\1\17\5\uffff\1\20",
            "\1\21\1\uffff\1\22\5\uffff\1\23",
            "\1\25\1\uffff\1\24",
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
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "153:1: cqlStatement returns [ParsedStatement stmt] : (st1= selectStatement | st2= insertStatement | st3= updateStatement | st4= batchStatement | st5= deleteStatement | st6= useStatement | st7= truncateStatement | st8= createKeyspaceStatement | st9= createColumnFamilyStatement | st10= createIndexStatement | st11= dropKeyspaceStatement | st12= dropColumnFamilyStatement | st13= dropIndexStatement | st14= alterTableStatement | st15= grantStatement | st16= revokeStatement | st17= listGrantsStatement | st18= alterKeyspaceStatement );";
        }
    }
    static final String DFA29_eotS =
        "\26\uffff";
    static final String DFA29_eofS =
        "\26\uffff";
    static final String DFA29_minS =
        "\1\6\23\7\2\uffff";
    static final String DFA29_maxS =
        "\1\120\23\166\2\uffff";
    static final String DFA29_acceptS =
        "\24\uffff\1\1\1\2";
    static final String DFA29_specialS =
        "\26\uffff}>";
    static final String[] DFA29_transitionS = {
            "\1\3\2\uffff\2\3\5\uffff\2\3\5\uffff\1\3\1\17\13\uffff\4\3\1"+
            "\uffff\1\1\2\uffff\1\3\10\uffff\1\3\5\uffff\1\2\5\uffff\1\4"+
            "\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\20\1\21\1"+
            "\22\1\23\1\3",
            "\1\24\154\uffff\1\24\1\uffff\1\25",
            "\1\24\154\uffff\1\24\1\uffff\1\25",
            "\1\24\154\uffff\1\24\1\uffff\1\25",
            "\1\24\154\uffff\1\24\1\uffff\1\25",
            "\1\24\154\uffff\1\24\1\uffff\1\25",
            "\1\24\154\uffff\1\24\1\uffff\1\25",
            "\1\24\154\uffff\1\24\1\uffff\1\25",
            "\1\24\154\uffff\1\24\1\uffff\1\25",
            "\1\24\154\uffff\1\24\1\uffff\1\25",
            "\1\24\154\uffff\1\24\1\uffff\1\25",
            "\1\24\154\uffff\1\24\1\uffff\1\25",
            "\1\24\154\uffff\1\24\1\uffff\1\25",
            "\1\24\154\uffff\1\24\1\uffff\1\25",
            "\1\24\154\uffff\1\24\1\uffff\1\25",
            "\1\24\154\uffff\1\24\1\uffff\1\25",
            "\1\24\154\uffff\1\24\1\uffff\1\25",
            "\1\24\154\uffff\1\24\1\uffff\1\25",
            "\1\24\154\uffff\1\24\1\uffff\1\25",
            "\1\24\154\uffff\1\24\1\uffff\1\25",
            "",
            ""
    };

    static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
    static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
    static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
    static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
    static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
    static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
    static final short[][] DFA29_transition;

    static {
        int numStates = DFA29_transitionS.length;
        DFA29_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = DFA29_eot;
            this.eof = DFA29_eof;
            this.min = DFA29_min;
            this.max = DFA29_max;
            this.accept = DFA29_accept;
            this.special = DFA29_special;
            this.transition = DFA29_transition;
        }
        public String getDescription() {
            return "325:1: deleteSelector returns [Selector s] : (c= cident | c= cident '[' t= term ']' );";
        }
    }
    static final String DFA51_eotS =
        "\26\uffff";
    static final String DFA51_eofS =
        "\1\uffff\23\25\2\uffff";
    static final String DFA51_minS =
        "\1\6\23\7\2\uffff";
    static final String DFA51_maxS =
        "\1\120\23\170\2\uffff";
    static final String DFA51_acceptS =
        "\24\uffff\1\1\1\2";
    static final String DFA51_specialS =
        "\26\uffff}>";
    static final String[] DFA51_transitionS = {
            "\1\3\2\uffff\2\3\5\uffff\2\3\5\uffff\1\3\1\17\13\uffff\4\3\1"+
            "\uffff\1\1\2\uffff\1\3\10\uffff\1\3\5\uffff\1\2\5\uffff\1\4"+
            "\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\20\1\21\1"+
            "\22\1\23\1\3",
            "\2\25\2\uffff\2\25\1\uffff\1\25\13\uffff\1\25\6\uffff\1\25"+
            "\11\uffff\1\25\1\uffff\2\25\2\uffff\1\25\77\uffff\2\25\5\uffff"+
            "\1\24",
            "\2\25\2\uffff\2\25\1\uffff\1\25\13\uffff\1\25\6\uffff\1\25"+
            "\11\uffff\1\25\1\uffff\2\25\2\uffff\1\25\77\uffff\2\25\5\uffff"+
            "\1\24",
            "\2\25\2\uffff\2\25\1\uffff\1\25\13\uffff\1\25\6\uffff\1\25"+
            "\11\uffff\1\25\1\uffff\2\25\2\uffff\1\25\77\uffff\2\25\5\uffff"+
            "\1\24",
            "\2\25\2\uffff\2\25\1\uffff\1\25\13\uffff\1\25\6\uffff\1\25"+
            "\11\uffff\1\25\1\uffff\2\25\2\uffff\1\25\77\uffff\2\25\5\uffff"+
            "\1\24",
            "\2\25\2\uffff\2\25\1\uffff\1\25\13\uffff\1\25\6\uffff\1\25"+
            "\11\uffff\1\25\1\uffff\2\25\2\uffff\1\25\77\uffff\2\25\5\uffff"+
            "\1\24",
            "\2\25\2\uffff\2\25\1\uffff\1\25\13\uffff\1\25\6\uffff\1\25"+
            "\11\uffff\1\25\1\uffff\2\25\2\uffff\1\25\77\uffff\2\25\5\uffff"+
            "\1\24",
            "\2\25\2\uffff\2\25\1\uffff\1\25\13\uffff\1\25\6\uffff\1\25"+
            "\11\uffff\1\25\1\uffff\2\25\2\uffff\1\25\77\uffff\2\25\5\uffff"+
            "\1\24",
            "\2\25\2\uffff\2\25\1\uffff\1\25\13\uffff\1\25\6\uffff\1\25"+
            "\11\uffff\1\25\1\uffff\2\25\2\uffff\1\25\77\uffff\2\25\5\uffff"+
            "\1\24",
            "\2\25\2\uffff\2\25\1\uffff\1\25\13\uffff\1\25\6\uffff\1\25"+
            "\11\uffff\1\25\1\uffff\2\25\2\uffff\1\25\77\uffff\2\25\5\uffff"+
            "\1\24",
            "\2\25\2\uffff\2\25\1\uffff\1\25\13\uffff\1\25\6\uffff\1\25"+
            "\11\uffff\1\25\1\uffff\2\25\2\uffff\1\25\77\uffff\2\25\5\uffff"+
            "\1\24",
            "\2\25\2\uffff\2\25\1\uffff\1\25\13\uffff\1\25\6\uffff\1\25"+
            "\11\uffff\1\25\1\uffff\2\25\2\uffff\1\25\77\uffff\2\25\5\uffff"+
            "\1\24",
            "\2\25\2\uffff\2\25\1\uffff\1\25\13\uffff\1\25\6\uffff\1\25"+
            "\11\uffff\1\25\1\uffff\2\25\2\uffff\1\25\77\uffff\2\25\5\uffff"+
            "\1\24",
            "\2\25\2\uffff\2\25\1\uffff\1\25\13\uffff\1\25\6\uffff\1\25"+
            "\11\uffff\1\25\1\uffff\2\25\2\uffff\1\25\77\uffff\2\25\5\uffff"+
            "\1\24",
            "\2\25\2\uffff\2\25\1\uffff\1\25\13\uffff\1\25\6\uffff\1\25"+
            "\11\uffff\1\25\1\uffff\2\25\2\uffff\1\25\77\uffff\2\25\5\uffff"+
            "\1\24",
            "\2\25\2\uffff\2\25\1\uffff\1\25\13\uffff\1\25\6\uffff\1\25"+
            "\11\uffff\1\25\1\uffff\2\25\2\uffff\1\25\77\uffff\2\25\5\uffff"+
            "\1\24",
            "\2\25\2\uffff\2\25\1\uffff\1\25\13\uffff\1\25\6\uffff\1\25"+
            "\11\uffff\1\25\1\uffff\2\25\2\uffff\1\25\77\uffff\2\25\5\uffff"+
            "\1\24",
            "\2\25\2\uffff\2\25\1\uffff\1\25\13\uffff\1\25\6\uffff\1\25"+
            "\11\uffff\1\25\1\uffff\2\25\2\uffff\1\25\77\uffff\2\25\5\uffff"+
            "\1\24",
            "\2\25\2\uffff\2\25\1\uffff\1\25\13\uffff\1\25\6\uffff\1\25"+
            "\11\uffff\1\25\1\uffff\2\25\2\uffff\1\25\77\uffff\2\25\5\uffff"+
            "\1\24",
            "\2\25\2\uffff\2\25\1\uffff\1\25\13\uffff\1\25\6\uffff\1\25"+
            "\11\uffff\1\25\1\uffff\2\25\2\uffff\1\25\77\uffff\2\25\5\uffff"+
            "\1\24",
            "",
            ""
    };

    static final short[] DFA51_eot = DFA.unpackEncodedString(DFA51_eotS);
    static final short[] DFA51_eof = DFA.unpackEncodedString(DFA51_eofS);
    static final char[] DFA51_min = DFA.unpackEncodedStringToUnsignedChars(DFA51_minS);
    static final char[] DFA51_max = DFA.unpackEncodedStringToUnsignedChars(DFA51_maxS);
    static final short[] DFA51_accept = DFA.unpackEncodedString(DFA51_acceptS);
    static final short[] DFA51_special = DFA.unpackEncodedString(DFA51_specialS);
    static final short[][] DFA51_transition;

    static {
        int numStates = DFA51_transitionS.length;
        DFA51_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA51_transition[i] = DFA.unpackEncodedString(DFA51_transitionS[i]);
        }
    }

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = DFA51_eot;
            this.eof = DFA51_eof;
            this.min = DFA51_min;
            this.max = DFA51_max;
            this.accept = DFA51_accept;
            this.special = DFA51_special;
            this.transition = DFA51_transition;
        }
        public String getDescription() {
            return "552:7: ( cfOrKsName[name, true] '.' )?";
        }
    }
    static final String DFA62_eotS =
        "\26\uffff";
    static final String DFA62_eofS =
        "\26\uffff";
    static final String DFA62_minS =
        "\1\6\23\166\2\uffff";
    static final String DFA62_maxS =
        "\1\120\23\174\2\uffff";
    static final String DFA62_acceptS =
        "\24\uffff\1\1\1\2";
    static final String DFA62_specialS =
        "\26\uffff}>";
    static final String[] DFA62_transitionS = {
            "\1\3\2\uffff\2\3\5\uffff\2\3\5\uffff\1\3\1\17\13\uffff\4\3\1"+
            "\uffff\1\1\2\uffff\1\3\10\uffff\1\3\5\uffff\1\2\5\uffff\1\4"+
            "\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\20\1\21\1"+
            "\22\1\23\1\3",
            "\1\25\5\uffff\1\24",
            "\1\25\5\uffff\1\24",
            "\1\25\5\uffff\1\24",
            "\1\25\5\uffff\1\24",
            "\1\25\5\uffff\1\24",
            "\1\25\5\uffff\1\24",
            "\1\25\5\uffff\1\24",
            "\1\25\5\uffff\1\24",
            "\1\25\5\uffff\1\24",
            "\1\25\5\uffff\1\24",
            "\1\25\5\uffff\1\24",
            "\1\25\5\uffff\1\24",
            "\1\25\5\uffff\1\24",
            "\1\25\5\uffff\1\24",
            "\1\25\5\uffff\1\24",
            "\1\25\5\uffff\1\24",
            "\1\25\5\uffff\1\24",
            "\1\25\5\uffff\1\24",
            "\1\25\5\uffff\1\24",
            "",
            ""
    };

    static final short[] DFA62_eot = DFA.unpackEncodedString(DFA62_eotS);
    static final short[] DFA62_eof = DFA.unpackEncodedString(DFA62_eofS);
    static final char[] DFA62_min = DFA.unpackEncodedStringToUnsignedChars(DFA62_minS);
    static final char[] DFA62_max = DFA.unpackEncodedStringToUnsignedChars(DFA62_maxS);
    static final short[] DFA62_accept = DFA.unpackEncodedString(DFA62_acceptS);
    static final short[] DFA62_special = DFA.unpackEncodedString(DFA62_specialS);
    static final short[][] DFA62_transition;

    static {
        int numStates = DFA62_transitionS.length;
        DFA62_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA62_transition[i] = DFA.unpackEncodedString(DFA62_transitionS[i]);
        }
    }

    class DFA62 extends DFA {

        public DFA62(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 62;
            this.eot = DFA62_eot;
            this.eof = DFA62_eof;
            this.min = DFA62_min;
            this.max = DFA62_max;
            this.accept = DFA62_accept;
            this.special = DFA62_special;
            this.transition = DFA62_transition;
        }
        public String getDescription() {
            return "593:1: termPairWithOperation[List<Pair<ColumnIdentifier, Operation>> columns] : (key= cident '=' (set_op= set_operation | c= cident op= operation | ll= list_literal '+' c= cident ) | key= cident '[' t= term ']' '=' vv= term );";
        }
    }
    static final String DFA61_eotS =
        "\13\uffff";
    static final String DFA61_eofS =
        "\13\uffff";
    static final String DFA61_minS =
        "\1\6\1\uffff\1\17\1\uffff\2\164\1\13\1\17\1\uffff\2\164";
    static final String DFA61_maxS =
        "\1\171\1\uffff\1\167\1\uffff\2\167\1\175\1\76\1\uffff\2\167";
    static final String DFA61_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\4\uffff\1\3\2\uffff";
    static final String DFA61_specialS =
        "\13\uffff}>";
    static final String[] DFA61_transitionS = {
            "\1\3\2\uffff\2\3\4\uffff\1\1\2\3\5\uffff\2\3\13\uffff\4\3\1"+
            "\uffff\1\3\2\uffff\1\3\5\uffff\1\1\2\uffff\1\3\5\uffff\1\3\3"+
            "\1\2\uffff\20\3\45\uffff\1\2\2\uffff\1\1",
            "",
            "\1\4\42\uffff\1\4\11\uffff\2\4\1\5\70\uffff\1\6",
            "",
            "\1\7\2\uffff\1\6",
            "\1\7\2\uffff\1\6",
            "\1\1\150\uffff\1\1\10\uffff\1\10",
            "\1\11\42\uffff\1\11\11\uffff\2\11\1\12",
            "",
            "\1\7\2\uffff\1\6",
            "\1\7\2\uffff\1\6"
    };

    static final short[] DFA61_eot = DFA.unpackEncodedString(DFA61_eotS);
    static final short[] DFA61_eof = DFA.unpackEncodedString(DFA61_eofS);
    static final char[] DFA61_min = DFA.unpackEncodedStringToUnsignedChars(DFA61_minS);
    static final char[] DFA61_max = DFA.unpackEncodedStringToUnsignedChars(DFA61_maxS);
    static final short[] DFA61_accept = DFA.unpackEncodedString(DFA61_acceptS);
    static final short[] DFA61_special = DFA.unpackEncodedString(DFA61_specialS);
    static final short[][] DFA61_transition;

    static {
        int numStates = DFA61_transitionS.length;
        DFA61_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA61_transition[i] = DFA.unpackEncodedString(DFA61_transitionS[i]);
        }
    }

    class DFA61 extends DFA {

        public DFA61(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 61;
            this.eot = DFA61_eot;
            this.eof = DFA61_eof;
            this.min = DFA61_min;
            this.max = DFA61_max;
            this.accept = DFA61_accept;
            this.special = DFA61_special;
            this.transition = DFA61_transition;
        }
        public String getDescription() {
            return "595:9: (set_op= set_operation | c= cident op= operation | ll= list_literal '+' c= cident )";
        }
    }
    static final String DFA64_eotS =
        "\15\uffff";
    static final String DFA64_eofS =
        "\15\uffff";
    static final String DFA64_minS =
        "\3\17\2\uffff\1\17\3\uffff\2\164\2\uffff";
    static final String DFA64_maxS =
        "\1\176\2\171\2\uffff\1\172\3\uffff\2\173\2\uffff";
    static final String DFA64_acceptS =
        "\3\uffff\1\2\1\1\1\uffff\1\3\1\6\1\4\2\uffff\1\5\1\7";
    static final String DFA64_specialS =
        "\15\uffff}>";
    static final String[] DFA64_transitionS = {
            "\1\3\56\uffff\1\3\76\uffff\1\1\1\2",
            "\1\4\56\uffff\1\4\67\uffff\1\6\2\uffff\1\5",
            "\1\3\56\uffff\1\3\67\uffff\1\10\2\uffff\1\7",
            "",
            "",
            "\1\11\42\uffff\1\11\11\uffff\2\11\1\12\73\uffff\1\13",
            "",
            "",
            "",
            "\1\13\5\uffff\1\13\1\14",
            "\1\13\5\uffff\1\13\1\14",
            "",
            ""
    };

    static final short[] DFA64_eot = DFA.unpackEncodedString(DFA64_eotS);
    static final short[] DFA64_eof = DFA.unpackEncodedString(DFA64_eofS);
    static final char[] DFA64_min = DFA.unpackEncodedStringToUnsignedChars(DFA64_minS);
    static final char[] DFA64_max = DFA.unpackEncodedStringToUnsignedChars(DFA64_maxS);
    static final short[] DFA64_accept = DFA.unpackEncodedString(DFA64_acceptS);
    static final short[] DFA64_special = DFA.unpackEncodedString(DFA64_specialS);
    static final short[][] DFA64_transition;

    static {
        int numStates = DFA64_transitionS.length;
        DFA64_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA64_transition[i] = DFA.unpackEncodedString(DFA64_transitionS[i]);
        }
    }

    class DFA64 extends DFA {

        public DFA64(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 64;
            this.eot = DFA64_eot;
            this.eof = DFA64_eof;
            this.min = DFA64_min;
            this.max = DFA64_max;
            this.accept = DFA64_accept;
            this.special = DFA64_special;
            this.transition = DFA64_transition;
        }
        public String getDescription() {
            return "619:1: operation returns [Operation op] : ( '+' v= intTerm | (sign= '-' )? v= intTerm | '+' ll= list_literal | '-' ll= list_literal | '+' sl= set_literal | '-' sl= set_literal | '+' ml= map_literal );";
        }
    }
    static final String DFA72_eotS =
        "\27\uffff";
    static final String DFA72_eofS =
        "\27\uffff";
    static final String DFA72_minS =
        "\1\6\23\100\3\uffff";
    static final String DFA72_maxS =
        "\1\120\23\u0082\3\uffff";
    static final String DFA72_acceptS =
        "\24\uffff\1\2\1\3\1\1";
    static final String DFA72_specialS =
        "\27\uffff}>";
    static final String[] DFA72_transitionS = {
            "\1\3\2\uffff\2\3\5\uffff\2\3\5\uffff\1\3\1\17\13\uffff\4\3\1"+
            "\uffff\1\1\2\uffff\1\3\10\uffff\1\3\5\uffff\1\2\3\uffff\1\24"+
            "\1\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
            "\1\20\1\21\1\22\1\23\1\3",
            "\1\25\73\uffff\1\26\2\uffff\4\26",
            "\1\25\73\uffff\1\26\2\uffff\4\26",
            "\1\25\73\uffff\1\26\2\uffff\4\26",
            "\1\25\73\uffff\1\26\2\uffff\4\26",
            "\1\25\73\uffff\1\26\2\uffff\4\26",
            "\1\25\73\uffff\1\26\2\uffff\4\26",
            "\1\25\73\uffff\1\26\2\uffff\4\26",
            "\1\25\73\uffff\1\26\2\uffff\4\26",
            "\1\25\73\uffff\1\26\2\uffff\4\26",
            "\1\25\73\uffff\1\26\2\uffff\4\26",
            "\1\25\73\uffff\1\26\2\uffff\4\26",
            "\1\25\73\uffff\1\26\2\uffff\4\26",
            "\1\25\73\uffff\1\26\2\uffff\4\26",
            "\1\25\73\uffff\1\26\2\uffff\4\26",
            "\1\25\73\uffff\1\26\2\uffff\4\26",
            "\1\25\73\uffff\1\26\2\uffff\4\26",
            "\1\25\73\uffff\1\26\2\uffff\4\26",
            "\1\25\73\uffff\1\26\2\uffff\4\26",
            "\1\25\73\uffff\1\26\2\uffff\4\26",
            "",
            "",
            ""
    };

    static final short[] DFA72_eot = DFA.unpackEncodedString(DFA72_eotS);
    static final short[] DFA72_eof = DFA.unpackEncodedString(DFA72_eofS);
    static final char[] DFA72_min = DFA.unpackEncodedStringToUnsignedChars(DFA72_minS);
    static final char[] DFA72_max = DFA.unpackEncodedStringToUnsignedChars(DFA72_maxS);
    static final short[] DFA72_accept = DFA.unpackEncodedString(DFA72_acceptS);
    static final short[] DFA72_special = DFA.unpackEncodedString(DFA72_specialS);
    static final short[][] DFA72_transition;

    static {
        int numStates = DFA72_transitionS.length;
        DFA72_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA72_transition[i] = DFA.unpackEncodedString(DFA72_transitionS[i]);
        }
    }

    class DFA72 extends DFA {

        public DFA72(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 72;
            this.eot = DFA72_eot;
            this.eof = DFA72_eof;
            this.min = DFA72_min;
            this.max = DFA72_max;
            this.accept = DFA72_accept;
            this.special = DFA72_special;
            this.transition = DFA72_transition;
        }
        public String getDescription() {
            return "658:1: relation[List<Relation> clauses] : (name= cident type= ( '=' | '<' | '<=' | '>=' | '>' ) t= term | K_TOKEN '(' name1= cident ( ',' namen= cident )* ')' type= ( '=' | '<' | '<=' | '>=' | '>' ) tkd= tokenDefinition | name= cident K_IN '(' f1= term ( ',' fN= term )* ')' );";
        }
    }
 

    public static final BitSet FOLLOW_cqlStatement_in_query72 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_113_in_query75 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_EOF_in_query79 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selectStatement_in_cqlStatement113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insertStatement_in_cqlStatement138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_updateStatement_in_cqlStatement163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_batchStatement_in_cqlStatement188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteStatement_in_cqlStatement214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_useStatement_in_cqlStatement239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_truncateStatement_in_cqlStatement267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_createKeyspaceStatement_in_cqlStatement290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_createColumnFamilyStatement_in_cqlStatement307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_createIndexStatement_in_cqlStatement319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dropKeyspaceStatement_in_cqlStatement338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dropColumnFamilyStatement_in_cqlStatement356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dropIndexStatement_in_cqlStatement370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alterTableStatement_in_cqlStatement391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_grantStatement_in_cqlStatement411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_revokeStatement_in_cqlStatement436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listGrantsStatement_in_cqlStatement460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alterKeyspaceStatement_in_cqlStatement480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_USE_in_useStatement510 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_keyspaceName_in_useStatement514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_SELECT_in_selectStatement548 = new BitSet(new long[]{0x082012F001830640L,0x002000000001FFFEL});
    public static final BitSet FOLLOW_selectClause_in_selectStatement554 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_K_COUNT_in_selectStatement559 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_114_in_selectStatement561 = new BitSet(new long[]{0x0000000000008000L,0x0020000000000000L});
    public static final BitSet FOLLOW_selectCountClause_in_selectStatement565 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_115_in_selectStatement567 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_K_FROM_in_selectStatement580 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_columnFamilyName_in_selectStatement584 = new BitSet(new long[]{0x0000000000005902L});
    public static final BitSet FOLLOW_K_USING_in_selectStatement594 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_K_CONSISTENCY_in_selectStatement596 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_K_LEVEL_in_selectStatement598 = new BitSet(new long[]{0x0000000000005802L});
    public static final BitSet FOLLOW_K_WHERE_in_selectStatement613 = new BitSet(new long[]{0x882012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_whereClause_in_selectStatement617 = new BitSet(new long[]{0x0000000000005002L});
    public static final BitSet FOLLOW_K_ORDER_in_selectStatement630 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_K_BY_in_selectStatement632 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_orderByClause_in_selectStatement634 = new BitSet(new long[]{0x0000000000004002L,0x0010000000000000L});
    public static final BitSet FOLLOW_116_in_selectStatement639 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_orderByClause_in_selectStatement641 = new BitSet(new long[]{0x0000000000004002L,0x0010000000000000L});
    public static final BitSet FOLLOW_K_LIMIT_in_selectStatement658 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_selectStatement662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selector_in_selectClause698 = new BitSet(new long[]{0x0000000000000002L,0x0010000000000000L});
    public static final BitSet FOLLOW_116_in_selectClause703 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_selector_in_selectClause707 = new BitSet(new long[]{0x0000000000000002L,0x0010000000000000L});
    public static final BitSet FOLLOW_117_in_selectClause719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cident_in_selector744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_WRITETIME_in_selector766 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_114_in_selector768 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_cident_in_selector772 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_115_in_selector774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_TTL_in_selector784 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_114_in_selector786 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_cident_in_selector790 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_115_in_selector792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_selectCountClause821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_selectCountClause843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relation_in_whereClause879 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_K_AND_in_whereClause883 = new BitSet(new long[]{0x882012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_relation_in_whereClause885 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_cident_in_orderByClause916 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_K_ASC_in_orderByClause921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DESC_in_orderByClause925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_INSERT_in_insertStatement963 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_K_INTO_in_insertStatement965 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_columnFamilyName_in_insertStatement969 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_114_in_insertStatement981 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_cident_in_insertStatement985 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_116_in_insertStatement992 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_cident_in_insertStatement996 = new BitSet(new long[]{0x0000000000000000L,0x0018000000000000L});
    public static final BitSet FOLLOW_115_in_insertStatement1003 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_K_VALUES_in_insertStatement1013 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_114_in_insertStatement1025 = new BitSet(new long[]{0x7004000000008000L,0x0240000000000000L});
    public static final BitSet FOLLOW_set_operation_in_insertStatement1029 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_116_in_insertStatement1035 = new BitSet(new long[]{0x7004000000008000L,0x0240000000000000L});
    public static final BitSet FOLLOW_set_operation_in_insertStatement1039 = new BitSet(new long[]{0x0000000000000000L,0x0018000000000000L});
    public static final BitSet FOLLOW_115_in_insertStatement1046 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_usingClause_in_insertStatement1058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_USING_in_usingClause1088 = new BitSet(new long[]{0x0000000001020200L});
    public static final BitSet FOLLOW_usingClauseObjective_in_usingClause1090 = new BitSet(new long[]{0x0000000001060202L});
    public static final BitSet FOLLOW_K_AND_in_usingClause1095 = new BitSet(new long[]{0x0000000001020200L});
    public static final BitSet FOLLOW_usingClauseObjective_in_usingClause1098 = new BitSet(new long[]{0x0000000001060202L});
    public static final BitSet FOLLOW_K_USING_in_usingClauseDelete1120 = new BitSet(new long[]{0x0000000001000200L});
    public static final BitSet FOLLOW_usingClauseDeleteObjective_in_usingClauseDelete1122 = new BitSet(new long[]{0x0000000001040202L});
    public static final BitSet FOLLOW_K_AND_in_usingClauseDelete1127 = new BitSet(new long[]{0x0000000001000200L});
    public static final BitSet FOLLOW_usingClauseDeleteObjective_in_usingClauseDelete1130 = new BitSet(new long[]{0x0000000001040202L});
    public static final BitSet FOLLOW_K_CONSISTENCY_in_usingClauseDeleteObjective1152 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_K_LEVEL_in_usingClauseDeleteObjective1154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_TIMESTAMP_in_usingClauseDeleteObjective1165 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_usingClauseDeleteObjective1169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_usingClauseDeleteObjective_in_usingClauseObjective1189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_TTL_in_usingClauseObjective1198 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INTEGER_in_usingClauseObjective1202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_UPDATE_in_updateStatement1236 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_columnFamilyName_in_updateStatement1240 = new BitSet(new long[]{0x0000000004000100L});
    public static final BitSet FOLLOW_usingClause_in_updateStatement1250 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_K_SET_in_updateStatement1262 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_termPairWithOperation_in_updateStatement1264 = new BitSet(new long[]{0x0000000000000800L,0x0010000000000000L});
    public static final BitSet FOLLOW_116_in_updateStatement1268 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_termPairWithOperation_in_updateStatement1270 = new BitSet(new long[]{0x0000000000000800L,0x0010000000000000L});
    public static final BitSet FOLLOW_K_WHERE_in_updateStatement1281 = new BitSet(new long[]{0x882012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_whereClause_in_updateStatement1285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DELETE_in_deleteStatement1325 = new BitSet(new long[]{0x082012F0018306C0L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_deleteSelection_in_deleteStatement1331 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_K_FROM_in_deleteStatement1344 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_columnFamilyName_in_deleteStatement1348 = new BitSet(new long[]{0x0000000000000900L});
    public static final BitSet FOLLOW_usingClauseDelete_in_deleteStatement1358 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_K_WHERE_in_deleteStatement1370 = new BitSet(new long[]{0x882012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_whereClause_in_deleteStatement1374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteSelector_in_deleteSelection1405 = new BitSet(new long[]{0x0000000000000002L,0x0010000000000000L});
    public static final BitSet FOLLOW_116_in_deleteSelection1410 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_deleteSelector_in_deleteSelection1414 = new BitSet(new long[]{0x0000000000000002L,0x0010000000000000L});
    public static final BitSet FOLLOW_cident_in_deleteSelector1441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cident_in_deleteSelector1468 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_118_in_deleteSelector1470 = new BitSet(new long[]{0x7004000000008000L});
    public static final BitSet FOLLOW_term_in_deleteSelector1474 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
    public static final BitSet FOLLOW_119_in_deleteSelector1476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_BEGIN_in_batchStatement1510 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_K_BATCH_in_batchStatement1512 = new BitSet(new long[]{0x000000000A200100L});
    public static final BitSet FOLLOW_usingClause_in_batchStatement1516 = new BitSet(new long[]{0x000000000A200100L});
    public static final BitSet FOLLOW_batchStatementObjective_in_batchStatement1534 = new BitSet(new long[]{0x000000004A200100L,0x0002000000000000L});
    public static final BitSet FOLLOW_113_in_batchStatement1536 = new BitSet(new long[]{0x000000004A200100L});
    public static final BitSet FOLLOW_batchStatementObjective_in_batchStatement1545 = new BitSet(new long[]{0x000000004A200100L,0x0002000000000000L});
    public static final BitSet FOLLOW_113_in_batchStatement1547 = new BitSet(new long[]{0x000000004A200100L});
    public static final BitSet FOLLOW_K_APPLY_in_batchStatement1561 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_K_BATCH_in_batchStatement1563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insertStatement_in_batchStatementObjective1594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_updateStatement_in_batchStatementObjective1607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteStatement_in_batchStatementObjective1620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_CREATE_in_createKeyspaceStatement1655 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_K_KEYSPACE_in_createKeyspaceStatement1657 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_keyspaceName_in_createKeyspaceStatement1661 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_K_WITH_in_createKeyspaceStatement1669 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_properties_in_createKeyspaceStatement1671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_CREATE_in_createColumnFamilyStatement1697 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_K_COLUMNFAMILY_in_createColumnFamilyStatement1699 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_columnFamilyName_in_createColumnFamilyStatement1703 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_cfamDefinition_in_createColumnFamilyStatement1713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_cfamDefinition1732 = new BitSet(new long[]{0x082012F801830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_cfamColumns_in_cfamDefinition1734 = new BitSet(new long[]{0x0000000000000000L,0x0018000000000000L});
    public static final BitSet FOLLOW_116_in_cfamDefinition1739 = new BitSet(new long[]{0x082012F801830640L,0x001800000001FFFEL});
    public static final BitSet FOLLOW_cfamColumns_in_cfamDefinition1741 = new BitSet(new long[]{0x0000000000000000L,0x0018000000000000L});
    public static final BitSet FOLLOW_115_in_cfamDefinition1748 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_K_WITH_in_cfamDefinition1758 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_cfamProperty_in_cfamDefinition1760 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_K_AND_in_cfamDefinition1765 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_cfamProperty_in_cfamDefinition1767 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_cident_in_cfamColumns1793 = new BitSet(new long[]{0x082412F005830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_comparatorType_in_cfamColumns1797 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_K_PRIMARY_in_cfamColumns1802 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_K_KEY_in_cfamColumns1804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_PRIMARY_in_cfamColumns1816 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_K_KEY_in_cfamColumns1818 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_114_in_cfamColumns1820 = new BitSet(new long[]{0x082012F001830640L,0x000400000001FFFEL});
    public static final BitSet FOLLOW_pkDef_in_cfamColumns1822 = new BitSet(new long[]{0x0000000000000000L,0x0018000000000000L});
    public static final BitSet FOLLOW_116_in_cfamColumns1826 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_cident_in_cfamColumns1830 = new BitSet(new long[]{0x0000000000000000L,0x0018000000000000L});
    public static final BitSet FOLLOW_115_in_cfamColumns1837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cident_in_pkDef1857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_pkDef1867 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_cident_in_pkDef1873 = new BitSet(new long[]{0x0000000000000000L,0x0018000000000000L});
    public static final BitSet FOLLOW_116_in_pkDef1879 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_cident_in_pkDef1883 = new BitSet(new long[]{0x0000000000000000L,0x0018000000000000L});
    public static final BitSet FOLLOW_115_in_pkDef1890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_property_in_cfamProperty1910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_COMPACT_in_cfamProperty1919 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_K_STORAGE_in_cfamProperty1921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_CLUSTERING_in_cfamProperty1931 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_K_ORDER_in_cfamProperty1933 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_K_BY_in_cfamProperty1935 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_114_in_cfamProperty1937 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_cfamOrdering_in_cfamProperty1939 = new BitSet(new long[]{0x0000000000000000L,0x0018000000000000L});
    public static final BitSet FOLLOW_116_in_cfamProperty1943 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_cfamOrdering_in_cfamProperty1945 = new BitSet(new long[]{0x0000000000000000L,0x0018000000000000L});
    public static final BitSet FOLLOW_115_in_cfamProperty1950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cident_in_cfamOrdering1978 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_K_ASC_in_cfamOrdering1981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DESC_in_cfamOrdering1985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_CREATE_in_createIndexStatement2014 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_K_INDEX_in_createIndexStatement2016 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_IDENT_in_createIndexStatement2021 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_K_ON_in_createIndexStatement2025 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_columnFamilyName_in_createIndexStatement2029 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_114_in_createIndexStatement2031 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_cident_in_createIndexStatement2035 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_115_in_createIndexStatement2037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_ALTER_in_alterKeyspaceStatement2077 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_K_KEYSPACE_in_alterKeyspaceStatement2079 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_keyspaceName_in_alterKeyspaceStatement2083 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_K_WITH_in_alterKeyspaceStatement2093 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_properties_in_alterKeyspaceStatement2095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_ALTER_in_alterTableStatement2131 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_K_COLUMNFAMILY_in_alterTableStatement2133 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_columnFamilyName_in_alterTableStatement2137 = new BitSet(new long[]{0x0000680200000000L});
    public static final BitSet FOLLOW_K_ALTER_in_alterTableStatement2151 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_cident_in_alterTableStatement2155 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_K_TYPE_in_alterTableStatement2157 = new BitSet(new long[]{0x082412F005830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_comparatorType_in_alterTableStatement2161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_ADD_in_alterTableStatement2177 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_cident_in_alterTableStatement2183 = new BitSet(new long[]{0x082412F005830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_comparatorType_in_alterTableStatement2187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DROP_in_alterTableStatement2210 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_cident_in_alterTableStatement2215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_WITH_in_alterTableStatement2255 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_properties_in_alterTableStatement2258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DROP_in_dropKeyspaceStatement2318 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_K_KEYSPACE_in_dropKeyspaceStatement2320 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_keyspaceName_in_dropKeyspaceStatement2324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DROP_in_dropColumnFamilyStatement2349 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_K_COLUMNFAMILY_in_dropColumnFamilyStatement2351 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_columnFamilyName_in_dropColumnFamilyStatement2355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DROP_in_dropIndexStatement2386 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_K_INDEX_in_dropIndexStatement2388 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_IDENT_in_dropIndexStatement2392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_TRUNCATE_in_truncateStatement2423 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_columnFamilyName_in_truncateStatement2427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_GRANT_in_grantStatement2461 = new BitSet(new long[]{0x070048008A200030L});
    public static final BitSet FOLLOW_permission_in_grantStatement2473 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_K_ON_in_grantStatement2481 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_columnFamilyName_in_grantStatement2495 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_K_TO_in_grantStatement2503 = new BitSet(new long[]{0x0004020000000000L});
    public static final BitSet FOLLOW_set_in_grantStatement2517 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_K_WITH_in_grantStatement2532 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_K_GRANT_in_grantStatement2534 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_K_OPTION_in_grantStatement2536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_REVOKE_in_revokeStatement2571 = new BitSet(new long[]{0x070048008A200030L});
    public static final BitSet FOLLOW_permission_in_revokeStatement2581 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_K_ON_in_revokeStatement2589 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_columnFamilyName_in_revokeStatement2601 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_K_FROM_in_revokeStatement2609 = new BitSet(new long[]{0x0004020000000000L});
    public static final BitSet FOLLOW_set_in_revokeStatement2621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_LIST_in_listGrantsStatement2656 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_K_GRANTS_in_listGrantsStatement2658 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_K_FOR_in_listGrantsStatement2660 = new BitSet(new long[]{0x0004020000000000L});
    public static final BitSet FOLLOW_set_in_listGrantsStatement2664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_permission2695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_cident2769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_NAME_in_cident2794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unreserved_keyword_in_cident2813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cfOrKsName_in_keyspaceName2846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cfOrKsName_in_columnFamilyName2880 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_columnFamilyName2883 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_cfOrKsName_in_columnFamilyName2887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_cfOrKsName2908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_NAME_in_cfOrKsName2933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unreserved_keyword_in_cfOrKsName2952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_set_operation2977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_literal_in_set_operation2997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_list_literal_in_set_operation3010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_literal_in_set_operation3022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_list_literal3046 = new BitSet(new long[]{0x7004000000008000L,0x0080000000000000L});
    public static final BitSet FOLLOW_term_in_list_literal3054 = new BitSet(new long[]{0x0000000000000000L,0x0090000000000000L});
    public static final BitSet FOLLOW_116_in_list_literal3060 = new BitSet(new long[]{0x7004000000008000L});
    public static final BitSet FOLLOW_term_in_list_literal3064 = new BitSet(new long[]{0x0000000000000000L,0x0090000000000000L});
    public static final BitSet FOLLOW_119_in_list_literal3074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_set_literal3097 = new BitSet(new long[]{0x7004000000008000L,0x0400000000000000L});
    public static final BitSet FOLLOW_term_in_set_literal3105 = new BitSet(new long[]{0x0000000000000000L,0x0410000000000000L});
    public static final BitSet FOLLOW_116_in_set_literal3111 = new BitSet(new long[]{0x7004000000008000L});
    public static final BitSet FOLLOW_term_in_set_literal3115 = new BitSet(new long[]{0x0000000000000000L,0x0410000000000000L});
    public static final BitSet FOLLOW_122_in_set_literal3125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_map_literal3154 = new BitSet(new long[]{0x7004000000008000L});
    public static final BitSet FOLLOW_term_in_map_literal3170 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_map_literal3172 = new BitSet(new long[]{0x7004000000008000L});
    public static final BitSet FOLLOW_term_in_map_literal3176 = new BitSet(new long[]{0x0000000000000000L,0x0410000000000000L});
    public static final BitSet FOLLOW_116_in_map_literal3182 = new BitSet(new long[]{0x7004000000008000L});
    public static final BitSet FOLLOW_term_in_map_literal3186 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_map_literal3188 = new BitSet(new long[]{0x7004000000008000L});
    public static final BitSet FOLLOW_term_in_map_literal3192 = new BitSet(new long[]{0x0000000000000000L,0x0410000000000000L});
    public static final BitSet FOLLOW_122_in_map_literal3199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_term3231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QMARK_in_term3258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_intTerm3320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QMARK_in_intTerm3332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cident_in_termPairWithOperation3356 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_124_in_termPairWithOperation3358 = new BitSet(new long[]{0x782412F001838640L,0x024000000001FFFEL});
    public static final BitSet FOLLOW_set_operation_in_termPairWithOperation3373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cident_in_termPairWithOperation3389 = new BitSet(new long[]{0x4000000000008000L,0x6000000000000000L});
    public static final BitSet FOLLOW_operation_in_termPairWithOperation3393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_list_literal_in_termPairWithOperation3419 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_125_in_termPairWithOperation3421 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_cident_in_termPairWithOperation3425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cident_in_termPairWithOperation3457 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_118_in_termPairWithOperation3459 = new BitSet(new long[]{0x7004000000008000L});
    public static final BitSet FOLLOW_term_in_termPairWithOperation3463 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
    public static final BitSet FOLLOW_119_in_termPairWithOperation3465 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_124_in_termPairWithOperation3467 = new BitSet(new long[]{0x7004000000008000L});
    public static final BitSet FOLLOW_term_in_termPairWithOperation3471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_operation3500 = new BitSet(new long[]{0x4000000000008000L,0x4000000000000000L});
    public static final BitSet FOLLOW_intTerm_in_operation3504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_operation3516 = new BitSet(new long[]{0x4000000000008000L,0x4000000000000000L});
    public static final BitSet FOLLOW_intTerm_in_operation3521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_operation3537 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_list_literal_in_operation3541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_operation3551 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_list_literal_in_operation3555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_operation3566 = new BitSet(new long[]{0x7004000000008000L,0x0240000000000000L});
    public static final BitSet FOLLOW_set_literal_in_operation3570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_operation3580 = new BitSet(new long[]{0x7004000000008000L,0x0240000000000000L});
    public static final BitSet FOLLOW_set_literal_in_operation3584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_operation3595 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_map_literal_in_operation3599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_property_in_properties3619 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_K_AND_in_properties3623 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_property_in_properties3625 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_cident_in_property3648 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_124_in_property3650 = new BitSet(new long[]{0x282412F001838640L,0x020000000001FFFEL});
    public static final BitSet FOLLOW_propertyValue_in_property3655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_literal_in_property3684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_propertyValue3712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unreserved_keyword_in_propertyValue3738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_TOKEN_in_tokenDefinition3786 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_114_in_tokenDefinition3799 = new BitSet(new long[]{0x7004000000008000L});
    public static final BitSet FOLLOW_term_in_tokenDefinition3803 = new BitSet(new long[]{0x0000000000000000L,0x0018000000000000L});
    public static final BitSet FOLLOW_116_in_tokenDefinition3809 = new BitSet(new long[]{0x7004000000008000L});
    public static final BitSet FOLLOW_term_in_tokenDefinition3813 = new BitSet(new long[]{0x0000000000000000L,0x0018000000000000L});
    public static final BitSet FOLLOW_115_in_tokenDefinition3821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_tokenDefinition3833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cident_in_relation3855 = new BitSet(new long[]{0x0000000000000000L,0x9000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_set_in_relation3859 = new BitSet(new long[]{0x7004000000008000L});
    public static final BitSet FOLLOW_term_in_relation3881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_TOKEN_in_relation3891 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_114_in_relation3902 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_cident_in_relation3906 = new BitSet(new long[]{0x0000000000000000L,0x0018000000000000L});
    public static final BitSet FOLLOW_116_in_relation3912 = new BitSet(new long[]{0x082012F001830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_cident_in_relation3916 = new BitSet(new long[]{0x0000000000000000L,0x0018000000000000L});
    public static final BitSet FOLLOW_115_in_relation3922 = new BitSet(new long[]{0x0000000000000000L,0x9000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_set_in_relation3937 = new BitSet(new long[]{0x8004000000000000L});
    public static final BitSet FOLLOW_tokenDefinition_in_relation3958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cident_in_relation3977 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_K_IN_in_relation3979 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_114_in_relation3990 = new BitSet(new long[]{0x7004000000008000L});
    public static final BitSet FOLLOW_term_in_relation3994 = new BitSet(new long[]{0x0000000000000000L,0x0018000000000000L});
    public static final BitSet FOLLOW_116_in_relation3999 = new BitSet(new long[]{0x7004000000008000L});
    public static final BitSet FOLLOW_term_in_relation4003 = new BitSet(new long[]{0x0000000000000000L,0x0018000000000000L});
    public static final BitSet FOLLOW_115_in_relation4010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_native_type_in_comparatorType4035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collection_type_in_comparatorType4051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_comparatorType4063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_ASCII_in_native_type4092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_BIGINT_in_native_type4106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_BLOB_in_native_type4119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_BOOLEAN_in_native_type4134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_COUNTER_in_native_type4146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DECIMAL_in_native_type4158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DOUBLE_in_native_type4170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_FLOAT_in_native_type4183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_INET_in_native_type4197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_INT_in_native_type4212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_TEXT_in_native_type4228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_TIMESTAMP_in_native_type4243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_UUID_in_native_type4253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_VARCHAR_in_native_type4268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_VARINT_in_native_type4280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_TIMEUUID_in_native_type4293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_MAP_in_collection_type4317 = new BitSet(new long[]{0x0000000000000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_127_in_collection_type4320 = new BitSet(new long[]{0x082412F005830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_comparatorType_in_collection_type4324 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_116_in_collection_type4326 = new BitSet(new long[]{0x082412F005830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_comparatorType_in_collection_type4330 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_130_in_collection_type4332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_LIST_in_collection_type4350 = new BitSet(new long[]{0x0000000000000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_127_in_collection_type4352 = new BitSet(new long[]{0x082412F005830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_comparatorType_in_collection_type4356 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_130_in_collection_type4358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_SET_in_collection_type4376 = new BitSet(new long[]{0x0000000000000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_127_in_collection_type4379 = new BitSet(new long[]{0x082412F005830640L,0x000000000001FFFEL});
    public static final BitSet FOLLOW_comparatorType_in_collection_type4383 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_130_in_collection_type4385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_unreserved_keyword4418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_native_type_in_unreserved_keyword4586 = new BitSet(new long[]{0x0000000000000002L});

}