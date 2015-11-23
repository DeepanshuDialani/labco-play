var React = require('react');
var ReactDOM = require('react-dom');
var ReactBSTable = require("./react-bootstrap-table-custom.min");
var BootstrapTable = ReactBSTable.BootstrapTable;
var TableHeaderColumn = ReactBSTable.TableHeaderColumn;
var TableDataSet = ReactBSTable.TableDataSet; 
function getDateFromTime(timeInSeconds) {
	var date = new Date(timeInSeconds*1000);
	var dd = date.getDate();
    var mm = date.getMonth()+1;
    var yyyy = date.getFullYear();
    if(dd<10){
        dd='0'+dd;
    } 
    if(mm<10){
        mm='0'+mm;
    }
    return dd + '/' + mm+'/' + yyyy;
}
var dataSet, reportDataMap;

function linkifyReportFormat(cell, row) {
	if(row.serial in reportDataMap) {
		var url = "/lab-record/" + reportDataMap[row.serial].id;
		return '<a href="' + url + '" target="_blank"> Link </a> ';
	} else {
		return '--';
	}
}

var MyBootstrapTable = React.createClass({
	getInitialState: function() {
		dataSet = new TableDataSet([]);
		reportDataMap = {};
		return {data: []};
	},
	parseNetworkResponse: function(data) {
		var labRecords = [];
		for(var index in data) {
			var record = data[index];
			var serialId = parseInt(index) + 1;
			if(record.is_report_generated) {
				reportDataMap[serialId] = record;
			}
			labRecords.push({
				"serial" : serialId,
				"patient-id" : record.patient_id,
				"name" : record.patient_name,
				"test" : record.test_name,
				"date" : getDateFromTime(record.test_time),
			});
		}
		return labRecords;
	},
	componentDidMount: function() {
		$.ajax({
		      url: this.props.source,
		      dataType: 'json',
		      cache: false,
		      success: function(data) {
		    	  console.log("onSuccess, source = " + this.props.source + ", data: " + JSON.stringify(data));
		  		  dataSet.setData(this.parseNetworkResponse(data));
		      }.bind(this),
		      error: function(xhr, status, err) {
		        console.error(this.props.source, status, err.toString());
		      }.bind(this)
		    });
	},
	render: function() {
		return (
				<BootstrapTable data={dataSet} search={true} striped={true} hover={true} height="500px">
				  <TableHeaderColumn isKey={true} dataSort={true} dataField="serial">#</TableHeaderColumn>
			      <TableHeaderColumn dataSort={true} dataField="patient-id">Patient Id</TableHeaderColumn>
			      <TableHeaderColumn dataSort={true} dataField="name">Name</TableHeaderColumn>
			      <TableHeaderColumn dataSort={true} dataField="test">Test</TableHeaderColumn>
			      <TableHeaderColumn dataSort={true} dataField="date">Date</TableHeaderColumn>
			      <TableHeaderColumn dataSort={true} dataFormat={linkifyReportFormat} dataField="report">Report</TableHeaderColumn>
			  </BootstrapTable>
		);
	}
});

ReactDOM.render(
		  <MyBootstrapTable source="https://demo3332037.mockable.io/lab-records" />,
		    document.getElementById("container")
		);