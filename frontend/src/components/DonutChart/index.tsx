import axios from 'axios';
import Chart from 'react-apexcharts';
import { SaleSam } from 'types/sale';
import { BASE_URL } from 'utils/requests';

type ChartData ={
    labels: string[];
    series: number[];
}

const DonutChat = () => {
    //FORMA ERRADA
    let chartData : ChartData = { labels: [], series: []};

     //FORMA ERRADA
    axios.get(`${BASE_URL}/sales/success-by-seller`)
        .then(Response => {
            const data = Response.data as SaleSam[]; 
            const myLabels = data.map(x => x.sallerName);
            const mySeries = data.map(x => x.sum);

            chartData = { labels: myLabels, series: mySeries};
            console.log(chartData);
        });

    //const mockData = {
    //    series: [477138, 499928, 444867, 220426, 473088],
    //    labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    //}

    const options = {
        legend: {
            show: true
        }
    }

    return (
        <Chart
            options={{ ...options, labels: chartData.labels }}
            series={chartData.series}
            type="donut"
            height="240"
        />
    );
}

export default DonutChat;
