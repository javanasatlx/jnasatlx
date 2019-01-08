<h1>jnasatlx v1.01 (2019-01-08)</h1>

<h4>What is this?</h4>

Hart and Staveland’s NASA Task Load Index (NASATLX) is a questionnaire for measuring subjective work load of a given task.

<a href="https://en.wikipedia.org/wiki/NASA-TLX" target="_blank">Click here for more information on Wikipedia.</a>

This work is a complete Java Swing Port of the NASA TLX Test implemented in Html and Javascript by Keith Vertanen.

<a href="http://www.keithv.com/software/nasatlx/" target="_blank">You can find his version here.</a>

jNasaTlx can be run standalone (a build script for the jar is included) or you can just use the classes in your project.
It's easy!

<h4>Supported languages</h4>
<ul>
  <li>English</li>
  <li>German</li>
</ul>

Do you want to port it to another language? Add your translations to <i>TlxLocalization.java</i> and contact me for a project update! It's easy!

<h4>Supported result output formats</h4>
<ul>
  <li>Html</li>
  <li>CSV</li>
  <li>XML (a XSD schema file for reimporting and code generation is included)</li>
  <li>Pojo</li>
</ul>

<h4>Some Screenshots</h4>
<ul>
  <li><a href="http://drive.google.com/uc?export=view&id=0B0-ieX8w3XYANVFtOElUT1N0MUk" target="_blank"> Screenshot 1</a></li>
  <li><a href="http://drive.google.com/uc?export=view&id=0B0-ieX8w3XYATHJ6eElWVHdwbEU" target="_blank"> Screenshot 2</a></li>
  <li><a href="http://drive.google.com/uc?export=view&id=0B0-ieX8w3XYASXI0RHhObzBlbTA" target="_blank"> Screenshot 3</a></li>
</ul>

<h4>Quick Start</h4>
Run in Maven with the following command line parameters:

`clean install exec:java -Dexec.mainClass=com.jnasatlx.TlxFrame "-Dexec.args=-language ENGLISH -loglevel DEBUG"`

<h4>License?</h4>

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 OTHER DEALINGS IN THE SOFTWARE.
 
It is appreciated if you put a reference to the original authors and me, though.<br>

<h4>Anything else?</h4>
If you add new features or translations - give them to me and I'll put them into the project (or try a pull request).<br>
This project has moved from <a href="https://code.google.com/p/jnasatlx/" target="_blank">google code (using SVN)</a>  to github in spring 2015 due to the immanent google code shutdown.<br>

<h4>Comments, Questions, Wishes?</h4>

Contact me via mail at javanasatlx_at_gmail.com

<h4>Project History</h4>

<ul>
<li>2019-01-08 (v1.01) <ul>
    <li>Project structure switched from Ant to Maven</li>
    <li>Lift of code to Java 1.8</li>
    <li>Mac compatibility issue fixed</li>
    <li>Documentation updated.</li>
    <li>Minor issues with encoding fixed (UTF-8)</li>
    <li>Minor refactorings throughout the code</li></ul>
<li>Spring 2015 <ul><li>Moved to Github due to closing of Google Code</li></ul></li>
<li>Spring 2014 (v1.00)<ul><li>Initial version on Google Code</li></ul></li>
</ul>