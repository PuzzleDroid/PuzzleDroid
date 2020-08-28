import Head from "next/head";
import {
  Box,
  Container,
  Grid,
  MenuItem,
  MenuList,
  Link,
  Typography,
  AppBar,
  Toolbar,
  CssBaseline,
} from "@material-ui/core";
import { useTranslation } from "next-translate";
import { createMuiTheme, ThemeProvider } from "@material-ui/core/styles";
import { useTheme } from "@material-ui/core/styles";

const theme = createMuiTheme({
  palette: {
    primary: {
      // light: will be calculated from palette.primary.main,
      main: "#ed7e00",
      dark: "#00171f",
    },
    secondary: {
      main: "#ed7e00",
      // dark: will be calculated from palette.secondary.main,
      contrastText: "#FBFBFB",
    },
    // Used by `getContrastText()` to maximize the contrast between
    // the background and the text.
    contrastThreshold: 3,
    // Used by the functions below to shift a color's luminance by approximately
    // two indexes within its tonal palette.
    // E.g., shift from Red 500 to Red 300 or Red 700.
    tonalOffset: 0.2,
  },
});

export default function Home() {
  const { t } = useTranslation();
  const sections = ["howto", "save", "win"];

  const shwoMenuItem = (key) => (
    <MenuItem>
      <Link href={`#${key}`}>{t(`${key}:title`)}</Link>
    </MenuItem>
  );

  const showContent = (key) => (
    <div id={key}>
      <Typography variant="h5" gutterBottom>
        {t(`${key}:title`)}
      </Typography>
      <Typography variant="body1" gutterBottom paragraph>
        {t(`${key}:content`)}
      </Typography>
    </div>
  );

  const { palette } = theme;

  return (
    <ThemeProvider theme={theme}>
      <Head>…</Head>
      <CssBaseline />
      <Container
        maxWidth="md"
        style={{ marginTop: "50px", marginBottom: "80px" }}
      >
        <Box style={{ padding: 20 }}>
          <Grid container spacing={10}>
            <Grid item xs={12} md={4}>
              <MenuList
                style={{
                  borderTop: `1px solid ${palette.primary.main}`,
                  borderBottom: `1px solid ${palette.primary.main}`,
                }}
              >
                {sections.map((key) => shwoMenuItem(key))}
              </MenuList>
            </Grid>
            <Grid item xs={12} md={8}>
              {sections.map((key) => showContent(key))}
            </Grid>
          </Grid>
        </Box>
      </Container>
      <AppBar
        color="secondary"
        style={{
          top: "auto",
          bottom: 0,
        }}
        position="static"
      >
        <Toolbar>
          <Container maxWidth="md">
            <Typography display="block" style={{ width: "100%" }} align="right">
              ©PuzzleDroid 2020
            </Typography>
          </Container>
        </Toolbar>
      </AppBar>
    </ThemeProvider>
  );
}

export const getStaticProps = async ({ lang }) => {
  return {
    props: {
      lang,
    },
  };
};
