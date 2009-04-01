/*
 * This plugin was initially developed by Daniel Einspanjer and is provided under the terms 
 * of the GNU Lesser General Public License, Version 2.1. You may not use 
 * this file except in compliance with the license. If you need a copy of the license, 
 * please go to http://www.gnu.org/licenses/lgpl-2.1.txt. 
 *
 * Software distributed under the GNU Lesser Public License is distributed on an "AS IS" 
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or  implied. Please refer to 
 * the license for the specific language governing your rights and limitations.
*/

package plugin.com.vertica.kettle.bulkloader;

import java.io.BufferedWriter;
import java.io.PipedOutputStream;

import org.pentaho.di.core.database.Database;
import org.pentaho.di.core.database.DatabaseMeta;
import org.pentaho.di.core.row.RowMetaInterface;
import org.pentaho.di.trans.step.BaseStepData;
import org.pentaho.di.trans.step.StepDataInterface;

public class VerticaBulkLoaderData extends BaseStepData implements StepDataInterface
{
    protected  Database db;
    protected  int      valuenrs[];
    
    protected RowMetaInterface outputRowMeta;
    protected RowMetaInterface insertRowMeta;

    protected DatabaseMeta databaseMeta;

    protected BufferedWriter writer;
    protected PipedOutputStream pipedOutputStream;

    protected String delimiter;
    protected String nullString;
    protected String recordTerminator;

    protected volatile Thread workerThread;

    protected VerticaBulkLoaderData()
	{
		super();
		
		db=null;
	}
}