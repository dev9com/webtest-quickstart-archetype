#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.remote;

import com.dynacrongroup.webtest.ParallelRunner;
import com.dynacrongroup.webtest.WebDriverBase;
import com.dynacrongroup.webtest.util.Path;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;

/**
 * This test runs as part of the lifecycle BEFORE the WAR has been created and
 * the web server has been started. That's why it has to go out to google.com -
 * that server is running regardless of this local web app.I
 * <p/>
 * It's mainly a nice, easy example of a test that should work with SauceLabs
 * even if you haven't set up sauce_connect.
 */
@RunWith( ParallelRunner.class )
public class SeleniumSimpleIT extends WebDriverBase {

    private final static Logger log = LoggerFactory
                                              .getLogger( SeleniumSimpleIT.class );

    Path p = new Path( "www.google.com", 80 );

    public SeleniumSimpleIT(String browser, String browserVersion) {
        super( browser, browserVersion );
        p.setContext("");
    }

    @Test
    public void firstTest() {
        log.info( "the browser is: " + this.getTargetWebBrowser().browser );
        driver.get( p._( "/" ) );
        assertTrue( driver.getPageSource().contains( "Google" ) );
    }

    @Test
    public void secondTest() {
        log.info( "this version is: " + this.getTargetWebBrowser().version );

        driver.get( p._( "/" ) );
        assertTrue( driver.getPageSource().contains( "Search" ) );
    }

    @Test
    public void logTest() {
        log.trace( "This is a trace message.  It will only appear if the log" );
        log.trace( "level is set to ${symbol_escape}"TRACE${symbol_escape}"." );
        log.debug( "This is a debug message.  It will only appear if the log" );
        log.debug( "level is set to ${symbol_escape}"TRACE${symbol_escape}" or ${symbol_escape}"DEBUG${symbol_escape}"." );
        log.info( "This is an info message.  It will only appear if the log" );
        log.info( "level is set to ${symbol_escape}"TRACE${symbol_escape}", ${symbol_escape}"DEBUG${symbol_escape}", or ${symbol_escape}"INFO${symbol_escape}"." );
        log.warn( "This is a warn message.  It will only appear if the log" );
        log.warn( "level is set to ${symbol_escape}"TRACE${symbol_escape}", ${symbol_escape}"DEBUG${symbol_escape}", ${symbol_escape}"INFO${symbol_escape}", or ${symbol_escape}"WARN${symbol_escape}"." );
        log.error( "This is an error message.  It will only appear if the log" );
        log.error( "level is set to any valid level." );
    }
}
