import React, { useEffect, useState } from "react";
import { Box, Typography, useTheme } from "@mui/material";
import { tokens } from '../../../theme';

import OrderService from "../../../services/OrderService";

export default function StudentData() {
  const theme = useTheme();
  const colors = tokens(theme.palette.mode);
  const [ordersCount, setOrdersCount] = useState(0);
 
  useEffect(() => { 

      OrderService.getCountOfPendingOrders().
      then((response)=>{
      console.log(response.data)
      setOrdersCount(response.data)})
      .catch((e)=>console.log(e));
  }, []);

  return (
    <Box bgcolor={colors.primary[600]} alignContent={'center'} height={'250px'}>
      <Typography variant="h4" align='center'>Pending Orders:</Typography><br/><br/><br/><br/>
      <Typography variant="h5" align="center"><h2> {ordersCount}</h2>  </Typography>
    </Box> 
  );
}